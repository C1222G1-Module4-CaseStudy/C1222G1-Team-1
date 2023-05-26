package com.example.castudy_module_4.model.product;

import org.hibernate.annotations.Cascade;

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


    private Integer quantityStorage;

    private String image;

    private Integer quantityStorage;
    private String imgage;

    @Column(name = "exp")
    private Date EXP;
    @Column(name = "mfg")
    private Date MFG;
    private Double weight;
    @Column(name = "descriptions")
    private String describe;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_type_product")
    private TypeProduct typeProduct;

    public Product() {
    }


    public Product(Integer id, String name, Double price, Integer quantityStorage, String image, Date EXP, Date MFG, Double weight, String describe, TypeProduct typeProduct) {


        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityStorage = quantityStorage;
        this.image = image;
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


    public Integer getQuantityStorage() {
        return quantityStorage;
    }

    public void setQuantityStorage(Integer quantityStorage) {
        this.quantityStorage = quantityStorage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

}
