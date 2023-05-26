package com.example.castudy_module_4.controller;

import com.example.castudy_module_4.dto.employeeDTO.BillDTO;
import com.example.castudy_module_4.dto.productDto.ProductDto;
import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.model.product.Product;
import com.example.castudy_module_4.service.IBillService;
import com.example.castudy_module_4.service.IPaymentService;
import com.example.castudy_module_4.service.IProductService;
import com.example.castudy_module_4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/bill")
@SessionAttributes("billDTO")
public class BillController {
    @ModelAttribute(name = "billDTO")
    private BillDTO initCartDTO() {
        return new BillDTO();
    }

    @Autowired
    private IBillService billService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IProductService productService;

    @Autowired
    private IPaymentService paymentService;

    @GetMapping()
    public String getBills(Model model) {
        model.addAttribute("bills", billService.getAll());
        return "/listBill";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("bill", new Bill());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("payments", paymentService.getAll());
        return "/createBill";
    }
    @PostMapping("/createBill")
    public String createBill(@ModelAttribute Bill bill, Model model){
       this.billService.save(bill);
       model.addAttribute("bill", bill);
        return "/updateBill";
    }
}
