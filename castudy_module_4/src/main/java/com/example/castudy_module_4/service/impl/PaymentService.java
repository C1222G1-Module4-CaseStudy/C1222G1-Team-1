package com.example.castudy_module_4.service.impl;

import com.example.castudy_module_4.model.Payment;
import com.example.castudy_module_4.repository.PaymentRepository;
import com.example.castudy_module_4.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }
}
