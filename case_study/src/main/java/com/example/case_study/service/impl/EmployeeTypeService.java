package com.example.case_study.service.impl;

import com.example.case_study.model.EmployeeType;
import com.example.case_study.repository.IEmployeeTypeRepository;
import com.example.case_study.service.IEmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeTypeService implements IEmployeeTypeService {
    @Autowired
    private IEmployeeTypeRepository employeeTypeRepository;

    @Override
    public List<EmployeeType> getAll() {
        return employeeTypeRepository.findAll();
    }
}
