package com.example.castudy_module_4.controller;

import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.service.IBillService;
import com.example.castudy_module_4.service.IPaymentService;
import com.example.castudy_module_4.service.IProductService;
import com.example.castudy_module_4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private IBillService billService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IProductService productService;

    @Autowired
    private IPaymentService paymentService;
    @GetMapping()
    public String getBills(Model model){
        model.addAttribute("bills", billService.getAll());
        return "/listBill";
    }

    @GetMapping("/create-form")
    public String createForm(Model model){
        model.addAttribute("bill", new Bill());
        model.addAttribute("users",userService.getAll());
        model.addAttribute("payments", paymentService.getAll());
        return "/createBill";
    }

    @PostMapping("/createBill")
    public String creatBill(@ModelAttribute Bill bill,Model model){
        model.addAttribute("bill");
        model.addAttribute("products",productService.findAll());
        return "/updateBill";
    }
}
