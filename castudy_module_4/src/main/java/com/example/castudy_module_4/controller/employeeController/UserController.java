package com.example.castudy_module_4.controller.employeeController;

import com.example.castudy_module_4.dto.employeeDTO.UserDto;
import com.example.castudy_module_4.model.Users;
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
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IEmployeeTypeService employeeTypeService;

    @GetMapping()
    public String showListEmployee(Model model) {
        model.addAttribute("employeeList", this.employeeService.getAll());
        return "/user/list";
    }
    @GetMapping("/profile")
    public String showProfile(){
        return "profile";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("employeeDTO", new UserDto());
        model.addAttribute("employeeType", this.employeeTypeService.getAll());
        return "/user/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Validated @ModelAttribute UserDto employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/create";
        }
        Users employee = new Users();
        BeanUtils.copyProperties(employeeDTO, employee);
        this.employeeService.save(employee);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam(value = "id") int id) {
        this.employeeService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String updateEmployee(@PathVariable(name = "id") int id, @ModelAttribute UserDto employeeDTO, Model model) {
        Users employee = this.employeeService.findById(id);
        BeanUtils.copyProperties(employee, employeeDTO);
        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("employeeType", this.employeeTypeService.getAll());
        return "/user/update";
    }

    @PostMapping("/update")
    public String updateEmployee(@Validated @ModelAttribute UserDto employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/update";
        }
Users employee=new Users();
        BeanUtils.copyProperties(employeeDTO,employee);
        this.employeeService.update(employee);
        return "redirect:/users";
    }

}
