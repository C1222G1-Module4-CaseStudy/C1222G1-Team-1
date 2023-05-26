package com.example.castudy_module_4.service;

import com.example.castudy_module_4.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void create(Product product);
    void update(Product product);
    void delete(Integer id);
    Product findById(int id);
    Page<Product> findAll(Pageable pageable);
    Page<Product> searchByName(String name, Pageable pageable);
    Page<Product> findByPrice(Double price, Pageable pageable);
}
