package com.example.castudy_module_4.controller.product;

import com.example.castudy_module_4.dto.productDto.ProductDto;
import com.example.castudy_module_4.model.product.Product;
import com.example.castudy_module_4.service.IProductService;
import com.example.castudy_module_4.service.ITypeProductService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "/products/list_product";
    }

    @GetMapping("/create-form-product")
    public String getCreateProduct(Model model) {
        model.addAttribute("productDto", new ProductDto());
        model.addAttribute("typeList", iTypeProductService.findAll());
        return "/products/create_product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("typeList", iTypeProductService.findAll());
            return "/products/create_product";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới sản phẩm thành công!");
        return "redirect:/product";
    }

}
