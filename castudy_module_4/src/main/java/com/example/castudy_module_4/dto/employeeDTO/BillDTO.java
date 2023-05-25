package com.example.castudy_module_4.dto.employeeDTO;

import java.util.LinkedHashMap;
import java.util.Map;

public class BillDTO {
    private final Map<Integer, Integer> selectedProduct;


    public BillDTO() {
        this.selectedProduct = new LinkedHashMap<>();
    }

    public Map<Integer, Integer> getSelectedProduct() {
        return selectedProduct;
    }
}
