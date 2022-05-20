package com.employeemanager.employeeManager.repo;

import com.employeemanager.employeeManager.models.AdsModels;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdsRepository extends PagingAndSortingRepository<AdsModels, Long> {
}
