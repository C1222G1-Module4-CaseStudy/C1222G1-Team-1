package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
