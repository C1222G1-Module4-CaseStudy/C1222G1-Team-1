package com.example.castudy_module_4.service;

import com.example.castudy_module_4.model.Users;

import java.util.List;

public interface IUserService {
    Users findUserByUsername(String name);

    List<Users> getAll();
}
