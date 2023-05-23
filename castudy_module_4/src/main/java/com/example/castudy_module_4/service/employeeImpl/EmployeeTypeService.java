package com.example.castudy_module_4.service.employeeImpl;

import com.example.castudy_module_4.model.employee.EmployeeType;
import com.example.castudy_module_4.repository.IEmployeeTypeRepository;
import com.example.castudy_module_4.service.IEmployeeTypeService;
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
