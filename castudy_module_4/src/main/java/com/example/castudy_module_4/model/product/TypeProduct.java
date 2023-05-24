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
//    @Column(name = "name_type")
    private String  nameTypeProduct;
    @OneToMany(mappedBy = "typeProduct")
private List<Product> products;

    public TypeProduct() {
    }

    public TypeProduct(int id, String nameTypeProduct, List<Product> products) {
        this.id = id;
        this.nameTypeProduct = nameTypeProduct;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
