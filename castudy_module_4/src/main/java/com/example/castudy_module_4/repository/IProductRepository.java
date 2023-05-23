package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
}
