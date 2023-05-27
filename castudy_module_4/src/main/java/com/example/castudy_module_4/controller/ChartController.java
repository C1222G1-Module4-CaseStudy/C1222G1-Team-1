package com.example.castudy_module_4.controller;

import com.example.castudy_module_4.model.Bill;
import com.example.castudy_module_4.model.custom.IChart;
import com.example.castudy_module_4.service.IChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChartController {
    @Autowired
    private IChartService chartService;

    @GetMapping("/report")
    public ResponseEntity<List<IChart>> report(){
        List<IChart> reports = chartService.reportBill();
        if (reports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reports, HttpStatus.OK);
    };
}
