package com.example.castudy_module_4.service;

import com.example.castudy_module_4.model.DetailBill;

public interface IDetailBillService {
    void save(DetailBill detailBill);

    DetailBill findByProductByBill(int id, int billId);
}