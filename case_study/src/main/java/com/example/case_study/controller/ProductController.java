package com.example.case_study.controller;

import com.example.case_study.dto.EmployeeDTO;
import com.example.case_study.model.Employee;
import com.example.case_study.service.IEmployeeService;
import com.example.case_study.service.IEmployeeTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class ProductController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IEmployeeTypeService employeeTypeService;

    @GetMapping()
    public String showListEmployee(Model model) {
        model.addAttribute("employeeList", this.employeeService.getAll());
        return "/employees/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("employeeType", this.employeeTypeService.getAll());
        return "/employees/create";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        this.employeeService.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam(value = "id") int id) {
        this.employeeService.delete(id);
        return "redirect:/employee";
    }

}
