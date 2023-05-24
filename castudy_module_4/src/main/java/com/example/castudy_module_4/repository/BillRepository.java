package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
