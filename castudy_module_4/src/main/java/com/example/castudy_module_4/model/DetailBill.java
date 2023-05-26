package com.example.castudy_module_4.model;

import com.example.castudy_module_4.model.product.Product;

import javax.persistence.*;

@Entity
@Table
public class DetailBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;

    private int quantity;

    public DetailBill() {
    }

    public DetailBill(int id, Product product, Bill bill, int quantity) {
        this.id = id;
        this.product = product;
        this.bill = bill;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
