package com.example.castudy_module_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/")
    public String listProduct(Model model){
        model.addAttribute("msg","xin chao");
        return "/list";
    }
}
