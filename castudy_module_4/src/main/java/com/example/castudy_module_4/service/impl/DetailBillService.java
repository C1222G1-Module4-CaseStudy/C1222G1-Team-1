package com.example.castudy_module_4.service.impl;

import com.example.castudy_module_4.model.DetailBill;
import com.example.castudy_module_4.repository.DetailBillRepository;
import com.example.castudy_module_4.service.IDetailBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailBillService implements IDetailBillService {
    @Autowired
    private DetailBillRepository detailBillRepository;

    @Override
    public void save(DetailBill detailBill) {
        if (detailBill.getQuantityOrder()==0){
            detailBill.setQuantityOrder(1);
        }else {
            detailBill.setQuantityOrder(detailBill.getQuantityOrder()+1);
        }
        detailBillRepository.save(detailBill);
    }

    @Override
    public DetailBill findByProductByBill(int id, int billId) {
        return detailBillRepository.findByProductByBill(id,billId);
    }
}
