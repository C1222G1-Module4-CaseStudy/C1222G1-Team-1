package com.example.castudy_module_4.model;

import com.example.castudy_module_4.model.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "detail_bill")
public class DetailBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity_order")
    private int quantityOrder;
    @Column(name = "total")
    private float total;

    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    public DetailBill() {
    }

    public DetailBill(int id, int quantityOrder, float total, Bill bill, Product product) {
        this.id = id;
        this.quantityOrder = quantityOrder;
        this.total = total;
        this.bill = bill;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
