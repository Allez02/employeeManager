package com.employeemanager.employeeManager.repo;

import com.employeemanager.employeeManager.models.PositionModels;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface PositionRepository extends PagingAndSortingRepository<PositionModels, Long> {
}
