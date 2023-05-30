package com.example.castudy_module_4.model;

import com.example.castudy_module_4.model.product.Product;

import javax.persistence.*;

@Entity
@Table
public class DetailBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetail;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_product" ,referencedColumnName = "id")
    private Product product;
    @ManyToOne()
    @JoinColumn(name = "id_bill",referencedColumnName = "id")
    private Bill bill;

    @Column(name = "quantity_order")
    private int quantityOrder;

    public DetailBill() {
    }

    public DetailBill(int idDetail, Product product, Bill bill, int quantityOrder) {
        this.idDetail = idDetail;
        this.product = product;
        this.bill = bill;
        this.quantityOrder = quantityOrder;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
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

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(int quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

}
