package com.employeemanager.employeeManager.repo;

import com.employeemanager.employeeManager.models.UsersModels;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends PagingAndSortingRepository<UsersModels, Long> {
    Optional<UsersModels> getByUsername(String username);
    List<UsersModels> getAllBy();
}
