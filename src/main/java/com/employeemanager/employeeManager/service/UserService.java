package com.employeemanager.employeeManager.service;

import com.employeemanager.employeeManager.entity.User;
import java.util.List;

public interface UserService {

    void createUser(String username, String password, String name, String surname, String information, Boolean createAdmin);

    void changeUser(String name, String surname, String information, User user);

    List<User> getAllUsersByApproved(Boolean isApproved);

    void lockedUser(Long userId, Boolean isLocked);

    void approvedUser(Long userId, Boolean approved);
}
