package com.example.castudy_module_4.service.employeeImpl;

import com.example.castudy_module_4.model.Users;
import com.example.castudy_module_4.repository.IEmployeeRepository;
import com.example.castudy_module_4.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Users> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Users employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Users findById(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void update(Users employee) {
        employeeRepository.save(employee);
    }
}
