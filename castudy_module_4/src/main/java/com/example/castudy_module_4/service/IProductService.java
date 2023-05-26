package com.example.castudy_module_4.service;

import com.example.castudy_module_4.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface IProductService {
    void create(Product product);
    void update(Product product);
    void delete(Integer id);
    Product findById(int id);
    Page<Product> findAll(Pageable pageable);
    Page<Product> searchByName(String name, Pageable pageable);
//    List<Product> showListTypeProduct(Integer id);
List<Product> getListProductByIds(Set<Integer> ids);

    List<Product> getAll();
    boolean checkId(int id);

    void UpQuantity(Product product,int quantity);
}
