package com.example.castudy_module_4.service.impl;

import com.example.castudy_module_4.model.DetailBill;
import com.example.castudy_module_4.repository.product.IDetailBillRepository;
import com.example.castudy_module_4.service.IDetailBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailBillService implements IDetailBillService {
    @Autowired
    private IDetailBillRepository detailBillRepository;

    @Override
    public void save(DetailBill detailBill) {
        if (detailBill.getQuantity()==0){
            detailBill.setQuantity(1);
        }else {
            detailBill.setQuantity(detailBill.getQuantity()+1);
        }
        detailBillRepository.save(detailBill);
    }
}
