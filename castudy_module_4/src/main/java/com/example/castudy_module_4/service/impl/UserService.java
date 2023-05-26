package com.example.castudy_module_4.service.impl;

import com.example.castudy_module_4.model.Users;
import com.example.castudy_module_4.repository.UserRepository;
import com.example.castudy_module_4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findUserByUsername(String name) {
        return userRepository.findByUserName(name);
    }

    @Override

    public List<Users> getAll() {
        return userRepository.findAll();

    public Users findById(int id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void update(Users users) {
        this.userRepository.save(users);
    }

    @Override
    public void create(Users users) {
        this.userRepository.save(users);
    }
}
