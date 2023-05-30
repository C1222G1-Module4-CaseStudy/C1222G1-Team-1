package com.example.castudy_module_4.service.impl;

import com.example.castudy_module_4.model.custom.IChart;
import com.example.castudy_module_4.repository.ChartRepository;
import com.example.castudy_module_4.service.IChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartService implements IChartService {
    @Autowired
    private ChartRepository chartRepository;

    @Override
    public List<IChart> reportBill() {
        return chartRepository.reportBill();
    }

    @Override
    public List<IChart> reportSale() {
        return chartRepository.reportSale();
    }
}
