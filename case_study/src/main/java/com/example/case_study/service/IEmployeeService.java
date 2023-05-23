package com.example.case_study.service;

import com.example.case_study.dto.EmployeeDTO;
import com.example.case_study.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    void save(Employee employee);

    void delete(int id);
}
