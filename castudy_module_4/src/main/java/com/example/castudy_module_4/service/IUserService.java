package com.example.castudy_module_4.service;

import com.example.castudy_module_4.dto.UserDto;
import com.example.castudy_module_4.model.Users;

public interface IUserService {
    Users findUserByUsername(String name);

    Users findById(int id);

    void update(Users users);

    void create(Users users);
//    void update()
}
