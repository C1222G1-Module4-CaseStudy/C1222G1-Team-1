package com.example.castudy_module_4.service.impl;

import com.example.castudy_module_4.model.TypeProduct;
import com.example.castudy_module_4.repository.ITypeProductRepository;
import com.example.castudy_module_4.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {
    @Autowired
    private ITypeProductRepository iTypeProductRepository;
    @Override
    public List<TypeProduct> findAll() {
        return iTypeProductRepository.findAll();
    }
}
