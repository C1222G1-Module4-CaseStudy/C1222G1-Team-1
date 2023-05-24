package com.example.castudy_module_4.model;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name_product")
    private String name;
    private Double price;
    private String img;
    @Column(name = "exp")
    private Date EXP;
    @Column(name = "mfg")
    private Date MFG;
    private Double weight;
    @Column(name = "descriptions")
    private String describe;

    @ManyToOne
    @JoinColumn(name = "id_type_product", referencedColumnName = "idTypeProduct")
    private TypeProduct typeProduct;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String img, Date EXP, Date MFG, Double weight, String describe, TypeProduct typeProduct) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.EXP = EXP;
        this.MFG = MFG;
        this.weight = weight;
        this.describe = describe;
        this.typeProduct = typeProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getEXP() {
        return EXP;
    }

    public void setEXP(Date EXP) {
        this.EXP = EXP;
    }

    public Date getMFG() {
        return MFG;
    }

    public void setMFG(Date MFG) {
        this.MFG = MFG;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
