package com.example.castudy_module_4.model.product;

import com.example.castudy_module_4.model.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_product")
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name_type")
    private String  nameType;
    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL)
    private List<Product> products;

    public TypeProduct() {
    }

    public TypeProduct(int id, String nameType, List<Product> products) {
        this.id = id;
        this.nameType = nameType;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}