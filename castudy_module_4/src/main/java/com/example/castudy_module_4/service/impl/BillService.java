package com.example.castudy_module_4.service.impl;

import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.repository.BillRepository;
import com.example.castudy_module_4.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {
    @Autowired
    private BillRepository billRepository;
    @Override
    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }
}
