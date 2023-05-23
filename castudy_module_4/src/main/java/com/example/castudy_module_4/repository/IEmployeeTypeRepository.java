package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.employee.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeTypeRepository extends JpaRepository<EmployeeType,Integer> {
}
