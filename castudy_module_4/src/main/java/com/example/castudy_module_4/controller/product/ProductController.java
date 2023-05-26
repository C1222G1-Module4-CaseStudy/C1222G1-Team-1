package com.example.castudy_module_4.controller.product;

import com.example.castudy_module_4.dto.productDto.ProductDto;
import com.example.castudy_module_4.model.product.Product;
import com.example.castudy_module_4.service.IProductService;
import com.example.castudy_module_4.service.ITypeProductService;
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
    public String listProduct(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)
                              Pageable pageable, Model model) {
        model.addAttribute("typeList", iTypeProductService.findAll());
        model.addAttribute("products", iProductService.findAll(pageable));
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

    @GetMapping("/edit/{id}")
    public String getEditProduct(@PathVariable Integer id, Model model) {
        Product product = iProductService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        model.addAttribute("productDto", productDto);
        model.addAttribute("typeList", iTypeProductService.findAll());
        return "/products/update_product";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("typeList", iTypeProductService.findAll());
            return "/products/update_product";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("msg", "Sửa sản phẩm thành công!");
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam(value = "idDelete") Integer id, RedirectAttributes redirectAttributes) {
        iProductService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Xoá thành công sản phẩm!");
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("products", iProductService.findById(id));
        model.addAttribute("typeProduct", iTypeProductService.findAll());
        return "/products/detail";
    }

    @GetMapping("/search-name")
    public String showListSearchName(@PageableDefault(value = 5, sort = "id", direction = Sort.Direction.DESC)
                                 Pageable pageable, @RequestParam(value = "searchByName", defaultValue = "")
                                 String searchByName, Model model) {
        model.addAttribute("products", iProductService.searchByName(searchByName, pageable));
        model.addAttribute("searchByName",searchByName);
        return "/products/list_product";
    }
    @GetMapping("/search-price")
    public String showListSearchPrice(Pageable pageable, @RequestParam(value = "searchByPrice", defaultValue = "")
                                 String searchByPrice, Model model) {
        model.addAttribute("products", iProductService.searchByName(searchByPrice, pageable));
        model.addAttribute("searchByName",searchByPrice);
        return "/products/list_product";
    }

//    @GetMapping

//
//    @GetMapping("/warehouse")
//    public String warehouse(Model model){
//        model.addAttribute("listProduct" , this.iProductService.findAll());
//
//        return "/products/warehouse";
//    }

}
