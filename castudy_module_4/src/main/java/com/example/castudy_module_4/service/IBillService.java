package com.example.castudy_module_4.service;

import com.example.castudy_module_4.dto.productDto.ProductDto;
import com.example.castudy_module_4.model.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBillService {
    Page<Bill> getAll(Pageable pageable);

    void save(Bill bill);

//    int totalBill(List<ProductDto> products);

    Bill findById(int billId);

    void deleteBYId(int id);

    List<Bill> findBillsByIdCustomer(int id);

}