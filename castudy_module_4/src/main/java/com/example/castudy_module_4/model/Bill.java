package com.example.castudy_module_4.model;

import com.example.castudy_module_4.model.product.Product;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
//import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameCustomer;


    private String phoneNumber;


    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;
    public Bill() {
    }

    public Bill(int id, String nameCustomer, String phoneNumber, Date saleDate, Users users, Payment payment) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.phoneNumber = phoneNumber;
        this.saleDate = saleDate;
        this.users = users;
        this.payment = payment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
