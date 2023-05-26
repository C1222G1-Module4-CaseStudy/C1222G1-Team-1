package com.example.castudy_module_4.controller;


import com.example.castudy_module_4.dto.UserDto;
import com.example.castudy_module_4.model.Users;
import com.example.castudy_module_4.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public String listUser(Model model){
        List<Users> usersList = this.userService.findAll();
        model.addAttribute("list" , usersList);
        return "user/list";
    }

    @GetMapping("/form-update/{id}")
    public String showFormUpdateProfile(@PathVariable int id , Model model){
        Users users =  this.userService.findById(id);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(users , userDto);
        model.addAttribute("user" , userDto);
        return "user/update";
    }
    @GetMapping("/form-create")
    public String showFormCreate(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user" , userDto);
        return "user/create";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute(value = "user") UserDto userDto , BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("user" , userDto);
            return "user/update";
        }
        Users users = new Users();
        BeanUtils.copyProperties(userDto , users);
        this.userService.update(users);
        return "redirect:/userInfo";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute(value = "user") UserDto userDto ,BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("user" , userDto);
            return "user/create";
        }
        Users users = new Users();
        BeanUtils.copyProperties(userDto , users);
        this.userService.create(users);
        return "redirect:/";
    }


}
