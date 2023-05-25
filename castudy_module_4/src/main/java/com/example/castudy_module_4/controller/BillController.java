package com.example.castudy_module_4.controller;


import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.service.IBillService;
import com.example.castudy_module_4.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BillController {
    @Autowired
    private IBillService billService;

    @Autowired
    private IPaymentService paymentService;
    @GetMapping("/bill")
    public String getBills(Model model){
        model.addAttribute("bills", billService.getAll());
        return "listBill";
    }

    @GetMapping("/create-form")
    public String createForm(Model model){
        model.addAttribute("bill", new Bill());
        model.addAttribute("payments", paymentService.getAll());
        return "createBill";
    }

    @PostMapping("/createBill")
    public String creatBill(@ModelAttribute Bill bill){
        billService.save(bill);
        return "redirect:/listBill";
    }
}
