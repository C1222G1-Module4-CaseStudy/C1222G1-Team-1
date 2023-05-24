package com.example.castudy_module_4.controller.product;

import com.example.castudy_module_4.service.IProductService;
import com.example.castudy_module_4.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ITypeProductService iTypeProductService;

    @GetMapping()
    public String listProduct(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.DESC)
                              Pageable pageable, @RequestParam(value = "searchByName", defaultValue = "")
                              String search, Model model) {
        model.addAttribute("typeList", iTypeProductService.findAll());
        model.addAttribute("products", iProductService.searchByName(search, pageable));
        model.addAttribute("searchByName", search);
        return "/product/list_product";
    }
}
