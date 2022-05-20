package com.employeemanager.employeeManager.repo;

import com.employeemanager.employeeManager.models.MessageModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends PagingAndSortingRepository<MessageModel, Long> {
}
