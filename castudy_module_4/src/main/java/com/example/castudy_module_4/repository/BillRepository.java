package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findBillsByUsers_Id(int id);
}
