package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
