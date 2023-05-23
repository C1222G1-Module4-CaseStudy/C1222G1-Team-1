package com.example.castudy_module_4.service.employeeImpl;

import com.example.castudy_module_4.model.employee.Employee;
import com.example.castudy_module_4.repository.IEmployeeRepository;
import com.example.castudy_module_4.repository.IEmployeeTypeRepository;
import com.example.castudy_module_4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }
}
