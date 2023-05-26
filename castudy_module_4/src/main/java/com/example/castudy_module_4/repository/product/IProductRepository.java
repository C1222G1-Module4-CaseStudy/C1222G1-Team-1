package com.example.castudy_module_4.repository.product;

import com.example.castudy_module_4.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
    Page<Product> searchByPrice(Double price, Pageable pageable);

    Page<Product> findByNameIsLikeIgnoreCase(String name, Pageable pageable);

}
