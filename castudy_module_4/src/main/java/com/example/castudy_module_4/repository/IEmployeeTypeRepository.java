package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeTypeRepository extends JpaRepository<Role,Integer> {
}
