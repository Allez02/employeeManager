package com.employeemanager.employeeManager.service;

import com.employeemanager.employeeManager.models.PositionModels;
import com.employeemanager.employeeManager.repo.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PositionService {

    private PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public ArrayList<PositionModels> getById(long id) {
        Optional<PositionModels> positionModels= positionRepository.findById(id);
        ArrayList<PositionModels> position = new ArrayList<>();
        positionModels.ifPresent(position::add);
        return position;
    }
}
