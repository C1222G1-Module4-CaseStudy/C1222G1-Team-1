package com.example.castudy_module_4.repository.product;

import com.example.castudy_module_4.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);

    @Query(value = "select * from Product " +
            "where name_product like %:searchByName% and price like %:searchByPrice% ",
            nativeQuery = true)
    List<Product> searchByProduct(@Param("searchByName") String searchByName,
                                  @Param("searchByPrice") String searchByPrice);
}
