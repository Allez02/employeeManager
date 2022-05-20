package com.employeemanager.employeeManager.service;

import com.employeemanager.employeeManager.models.AdsModels;
import org.springframework.stereotype.Service;

public interface AdsService {
    Iterable<AdsModels> getAll();


}
