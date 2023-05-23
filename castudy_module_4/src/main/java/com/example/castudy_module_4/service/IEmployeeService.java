package com.example.castudy_module_4.service;

import com.example.castudy_module_4.dto.employeeDTO.EmployeeDTO;
import com.example.castudy_module_4.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    void save(Employee employee);

    void delete(int id);

    Employee findById(int id);

    void update(Employee employee);
}
