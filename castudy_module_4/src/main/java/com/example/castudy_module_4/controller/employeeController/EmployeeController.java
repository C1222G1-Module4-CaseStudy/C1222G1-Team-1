package com.example.castudy_module_4.controller.employeeController;

import com.example.castudy_module_4.dto.employeeDTO.EmployeeDTO;
import com.example.castudy_module_4.model.employee.Employee;
import com.example.castudy_module_4.service.IEmployeeService;
import com.example.castudy_module_4.service.IEmployeeTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
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
    public String createEmployee(@Validated @ModelAttribute EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/employees/create";
        }
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

    @GetMapping("/{id}/update")
    public String updateEmployee(@PathVariable(name = "id") int id, @ModelAttribute EmployeeDTO employeeDTO, Model model) {
        Employee employee = this.employeeService.findById(id);
        BeanUtils.copyProperties(employee, employeeDTO);
        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("employeeType", this.employeeTypeService.getAll());
        return "/employees/update";
    }

    @PostMapping("/update")
    public String updateEmployee(@Validated @ModelAttribute EmployeeDTO employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/employees/update";
        }
Employee employee=new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        this.employeeService.update(employee);
        return "redirect:/employee";
    }

}
