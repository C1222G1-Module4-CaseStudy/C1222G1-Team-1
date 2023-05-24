package com.example.castudy_module_4.service;

import com.example.castudy_module_4.model.Users;

public interface IUserService {
    Users findUserByUsername(String name);
}
