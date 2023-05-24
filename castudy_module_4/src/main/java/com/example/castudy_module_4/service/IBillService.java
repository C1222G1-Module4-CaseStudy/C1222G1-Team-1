package com.example.castudy_module_4.service;

import com.example.castudy_module_4.model.Bill;

import java.util.List;

public interface IBillService {
    List<Bill> getAll();

    void save(Bill bill);
}
