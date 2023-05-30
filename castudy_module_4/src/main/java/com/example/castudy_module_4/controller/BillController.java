package com.example.castudy_module_4.controller;

import com.example.castudy_module_4.dto.employeeDTO.BillDTO;
import com.example.castudy_module_4.dto.productDto.ProductDto;
import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.model.Users;
import com.example.castudy_module_4.model.product.Product;
import com.example.castudy_module_4.service.IBillService;
import com.example.castudy_module_4.service.IPaymentService;
import com.example.castudy_module_4.service.IProductService;
import com.example.castudy_module_4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
    public String getBills(Model model, @PageableDefault(size = 5 ,sort = "id",direction = Sort.Direction.DESC)Pageable pageable) {
        model.addAttribute("bills", billService.getAll(pageable));
        return "/listBill";
    }

    @GetMapping("/goCreateBill")
    public String createForm(Model model) {
        model.addAttribute("bill", new Bill());
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Users users = userService.findUserByUsername(auth.getName());
//        model.addAttribute("user",users);
        model.addAttribute("users", userService.getAll());
        model.addAttribute("payments", paymentService.getAll());
        return "/createBill";
    }
    @PostMapping("/createBill")
    public String createBill(@ModelAttribute(value = "bill") Bill bill, Model model){
        this.billService.save(bill);
        model.addAttribute("bill", bill);
        model.addAttribute("listBill",billService.findBillsByIdCustomer(bill.getUsers().getId()));
        return "/infoBill";
    }
    @GetMapping("deleteBill")
    public String deleteBill(int id, RedirectAttributes redirectAttributes){
        billService.deleteBYId(id);
        redirectAttributes.addFlashAttribute("message","xóa thành công");
        return "redirect:/bill";

    }

//     method goInfoBill
//     param billId: get info user, get list product (user)
    // model
    // return infoBill.html
}