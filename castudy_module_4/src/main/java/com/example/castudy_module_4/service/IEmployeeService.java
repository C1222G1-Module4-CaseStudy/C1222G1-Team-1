package com.example.castudy_module_4.service;

import com.example.castudy_module_4.model.Users;

import java.util.List;

public interface IEmployeeService {
    List<Users> getAll();

    void save(Users employee);

    void delete(int id);

    Users findById(int id);

    void update(Users employee);
}
