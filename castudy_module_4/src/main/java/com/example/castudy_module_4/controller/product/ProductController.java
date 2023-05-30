package com.example.castudy_module_4.controller.product;

import com.example.castudy_module_4.dto.employeeDTO.BillDTO;
import com.example.castudy_module_4.dto.productDto.ProductDto;
import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.model.DetailBill;
import com.example.castudy_module_4.model.product.Product;
import com.example.castudy_module_4.service.*;
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

//    @GetMapping("/{id}/add-to-bill/{billId}")
//    public String addToBill(@PathVariable(name = "id") int id, @PathVariable("billId") int billId, @SessionAttribute(name = "billDTO") BillDTO billDTO,
//                            Model model
//    ) {
//        // Lưu xuống bảng bill_detail
//        DetailBill detailBill = new DetailBill();
//        detailBill.setBill(iBillService.findById(billId));
//        detailBill.setProduct(iProductService.findById(id));
//        detailBill.setQuantity(1);
//        iDetailBillService.save(detailBill);
//        model.addAttribute("billId", billId);
//        model.addAttribute("typeList", iTypeProductService.findAll());
//        model.addAttribute("products", iProductService.getAll());
//        model.addAttribute("billId", billId);
//        return "/products/list_product";
//    }

    @GetMapping()
    public String listProduct(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)
                              Pageable pageable,String billId,  Model model) {
        model.addAttribute("typeList", iTypeProductService.findAll());
        model.addAttribute("products", iProductService.findAll(pageable));
        model.addAttribute("billId", billId);
        return "/products/list_product";
    }

    @GetMapping("/{id}/add-to-bill/{billId}")
    public String addToBill(@PathVariable(name = "id") int id, @PathVariable( name = "billId") int billId, Model model,@PageableDefault(size = 5)Pageable pageable) {
        // Lưu xuống bảng bill_detail
        DetailBill detailBill = iDetailBillService.findByProductByBill(id, billId);
        if (detailBill == null) {
            detailBill = new DetailBill();
            detailBill.setBill(iBillService.findById(billId));
            detailBill.setProduct(iProductService.findById(id));
            detailBill.setQuantityOrder(1);
        } else {
            Product product = iProductService.findById(id);
            detailBill.setQuantityOrder(detailBill.getQuantityOrder() + 1);
            detailBill.setProduct(product);
        }
        iDetailBillService.save(detailBill);
        model.addAttribute("billDetail", detailBill);
        model.addAttribute("products", iProductService.findAll(pageable));
        model.addAttribute("billsId", billId);
        return "/products/list_product";
    }
    @GetMapping("/goInfoBill/{id}")
    public String goInfoBill(Model model, @PathVariable int id) {
        model.addAttribute("bill", iBillService.findById(id));
        model.addAttribute("product",iProductService.findById(id));
        return "/infoBill";
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
        if(product.getImage() != null & product.getImage().startsWith(",")) {
            product.setImage(product.getImage().substring(1));
        }
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("msg2", "Thêm mới sản phẩm thành công!");
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
        redirectAttributes.addFlashAttribute("msg1", "Sửa sản phẩm thành công!");
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

    @GetMapping("/search-product")
    public String showListSearchProduct(@RequestParam(value = "searchByName", defaultValue = "") String searchByName,
                                        @RequestParam(value = "searchByPrice", defaultValue = "")
                                        String searchByPrice, Model model) {

        model.addAttribute("product", iProductService.findByProduct(searchByName,searchByPrice));
        model.addAttribute("searchByName", searchByName);
        model.addAttribute("searchByPrice", searchByPrice);
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
    public String warehouse(@PathVariable("id") int id, @RequestParam("numberWareHouse") int quantity, RedirectAttributes redirectAttributes) {
        Product product = this.iProductService.findById(id);
        this.iProductService.UpQuantity(product, quantity);
        redirectAttributes.addFlashAttribute("messageSuccess", "Nhập kho thành công");
        return "redirect:/product";
    }


    @PostMapping("/saveBill")
    public String saveBill(@ModelAttribute Bill bill, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("messages","Lưu thành công");
        return "redirect:/bill";
    }
    }
