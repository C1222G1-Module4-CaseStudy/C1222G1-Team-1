package com.example.castudy_module_4.service;

import com.example.castudy_module_4.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<Product> findAll();
    void create(Product product);
    void update(Product product);
    void delete(Integer id);
    Product findById(int id);

}
