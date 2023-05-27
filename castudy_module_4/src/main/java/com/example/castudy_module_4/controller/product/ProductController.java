package com.example.castudy_module_4.controller.product;

import com.example.castudy_module_4.dto.employeeDTO.BillDTO;
import com.example.castudy_module_4.dto.productDto.ProductDto;
import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.model.DetailBill;
import com.example.castudy_module_4.model.product.Product;
import com.example.castudy_module_4.service.*;

import com.fasterxml.jackson.databind.util.BeanUtil;
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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/product")
@SessionAttributes(value = "billDTO")
public class ProductController {
    @ModelAttribute(name = "billDTO")
    private BillDTO initCartDTO() {
        return new BillDTO();
    }
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IBillService iBillService;
    @Autowired
    private IDetailBillService iDetailBillService;

    @Autowired
    private ITypeProductService iTypeProductService;

    @GetMapping()

    public String listProduct(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)
                              Pageable pageable, Model model) {
        model.addAttribute("typeList", iTypeProductService.findAll());
        model.addAttribute("products", iProductService.findAll(pageable));

        return "/products/list_product";
    }
    @GetMapping("/{id}/add-to-bill/{billId}")
    public String addToBill(@PathVariable(name = "id") int id, @PathVariable("billId") int billId, @SessionAttribute(name = "billDTO") BillDTO billDTO,
                            Model model
    ) {
        // Lưu xuống bảng bill_detail
        DetailBill detailBill = new DetailBill();
        detailBill.setBill(iBillService.findById(billId));
        detailBill.setProduct(iProductService.findById(id));
        detailBill.setQuantity(1);
        iDetailBillService.save(detailBill);
//        Product product = iProductService.findById(id);
//        boolean addProduct = false;
//        for (Map.Entry<Integer, Integer> entry : billDTO.getSelectedProduct().entrySet()) {
//            if (entry.getKey().equals(product.getId())) {
//                entry.setValue(entry.getValue() + 1);
//                addProduct = true;
//            }
//        }
//        if (!addProduct) {
//            billDTO.getSelectedProduct().put(product.getId(), 1);
//        }
        model.addAttribute("billId", billId);
        model.addAttribute("typeList", iTypeProductService.findAll());
        model.addAttribute("products", iProductService.getAll());
        model.addAttribute("billId", billId);
        return "/products/list_product";
    }
//    @GetMapping("/product-add-to-bill")
//    public String getProductsFromBill(@SessionAttribute(name = "billDTO") BillDTO billDTO, Model model) {
//        Set<Integer> productIds = billDTO.getSelectedProduct().keySet();
//
//        Map<Integer, Product> mapProducts = iProductService.getListProductByIds(productIds).stream()
//                .collect(Collectors.toMap(Product::getId, p -> p));
//
//        List<ProductDto> products = billDTO.getSelectedProduct().entrySet().stream().
//                map(e -> new ProductDto(e.getKey()
//                        , mapProducts.get(e.getKey()).getNameProduct(),
//                        mapProducts.get(e.getKey()).getPrice(),
//                        e.getValue(),
//                        mapProducts.get(e.getKey()).getImage(),
//                        mapProducts.get(e.getKey()).getEXP(),
//                        mapProducts.get(e.getKey()).getMFG(),
//                        mapProducts.get(e.getKey()).getWeight(),
//                        mapProducts.get(e.getKey()).getDescriptions(),
//                        mapProducts.get(e.getKey()).getPrice() * e.getValue(),
//                        mapProducts.get(e.getKey()).getTypeProduct())).
//                collect(Collectors.toCollection(LinkedList::new));
//        model.addAttribute("total", iBillService.totalBill(products));
//        model.addAttribute("products", products);
//        return "/createBill";
//    }


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


    @GetMapping("/formcheckid")
    public String showFormCheckId(){
        return "/products/inputwarehouse";
    }

    @GetMapping("checkid")
    public String checkId(@RequestParam(name = "numberId") int id , Model model){
        boolean flag = this.iProductService.checkId(id);
        if(flag){
            model.addAttribute("flag" , flag);
            return "/products/inputwarehouse";
        }
        model.addAttribute("product" , this.iProductService.findById(id));
        return "/products/warehouse";
        }


    @PostMapping("/warehouse/{id}")
    public String warehouse(@PathVariable("id") int id,@RequestParam("numberWareHouse")int quantity, Model model){
        Product product = this.iProductService.findById(id);
        this.iProductService.UpQuantity(product,quantity);
        return "redirect:/";
    }
    }
