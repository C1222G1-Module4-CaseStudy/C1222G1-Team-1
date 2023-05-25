package com.example.castudy_module_4.repository.product;

import com.example.castudy_module_4.model.DetailBill;
import com.example.castudy_module_4.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IDetailBillRepository extends JpaRepository<DetailBill, Integer> {
}
