package com.example.case_study.repository;

import com.example.case_study.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeTypeRepository extends JpaRepository<EmployeeType,Integer> {
}
