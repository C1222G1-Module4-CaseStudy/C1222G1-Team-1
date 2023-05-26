package com.example.castudy_module_4.service.productImpl;

import com.example.castudy_module_4.model.product.Product;
import com.example.castudy_module_4.repository.product.IProductRepository;
import com.example.castudy_module_4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void create(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return iProductRepository.findByNameIsLikeIgnoreCase("%" + name + "%", pageable);
    }

    @Override
    public Page<Product> findByPrice(Double price, Pageable pageable) {
        return iProductRepository.searchByPrice(price, pageable);
    }

}
