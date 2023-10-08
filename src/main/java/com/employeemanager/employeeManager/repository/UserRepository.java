package com.employeemanager.employeeManager.repository;

import com.employeemanager.employeeManager.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Optional<User> getByUsername(String username);
}
