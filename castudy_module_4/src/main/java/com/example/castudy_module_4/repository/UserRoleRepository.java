package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.UserRole;
import com.example.castudy_module_4.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUsers(Users users);
}