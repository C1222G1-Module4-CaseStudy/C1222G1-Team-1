package com.example.castudy_module_4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTypeProduct;
    private String  nameTypeProduct;
    @OneToMany(mappedBy = "typeProduct")
private List<Product> products;

    public TypeProduct() {
    }

    public TypeProduct(Integer idTypeProduct, String nameTypeProduct, List<Product> products) {
        this.idTypeProduct = idTypeProduct;
        this.nameTypeProduct = nameTypeProduct;
        this.products = products;
    }

    public Integer getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(Integer idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getNameTypeProduct() {
        return nameTypeProduct;
    }

    public void setNameTypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
