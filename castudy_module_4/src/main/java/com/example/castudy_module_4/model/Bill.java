package com.example.castudy_module_4.model;

import javax.persistence.*;
import java.sql.Date;
//import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "sale_date")
    private Date saleDate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "id_payment")
    private Payment payment;

    public Bill() {
    }

    public interface BillView {
        java.util.Date getSaleDate();
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
