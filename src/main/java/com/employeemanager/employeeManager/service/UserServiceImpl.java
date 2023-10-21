package com.employeemanager.employeeManager.service;

import com.employeemanager.employeeManager.entity.User;
import com.employeemanager.employeeManager.repository.RoleRepository;
import com.employeemanager.employeeManager.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public void createUser(String username, String password, String name, String surname, String information, Boolean createAdmin) {
        if(userRepository.existsUserByUsername(username)) {
            throw new RuntimeException("Пользователь с таким username уже существует");
        }
        var user = new User(username, password, name, surname, information, createAdmin ? roleRepository.getById(1L) : roleRepository.getById(2L));
        this.userRepository.save(user);
    }

    @Override
    public void changeUser(String name, String surname, String information, User user) {
        user.setName(name);
        user.setSurname(surname);
        user.setInformation(information);
        this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsersByApproved(Boolean isApproved) {
        return this.userRepository.findAllByIsApproved(isApproved);
    }

    @Override
    public void lockedUser(Long userId, Boolean isLocked) {
        var user = this.userRepository.findById(userId).orElseThrow();
        user.setIsNonLocked(!isLocked);
        this.userRepository.save(user);
    }

    @Override
    public void approvedUser(Long userId) {
        var user = this.userRepository.findById(userId).orElseThrow();
        user.setIsApproved(true);
        this.userRepository.save(user);
    }

}
