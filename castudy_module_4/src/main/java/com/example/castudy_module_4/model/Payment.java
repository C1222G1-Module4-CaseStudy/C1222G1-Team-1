package com.example.castudy_module_4.model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_payment")
    private String typePayment;

    public Payment() {
    }

    public Payment(int id, String typePayment) {
        this.id = id;
        this.typePayment = typePayment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(String typePayment) {
        this.typePayment = typePayment;
    }
}
