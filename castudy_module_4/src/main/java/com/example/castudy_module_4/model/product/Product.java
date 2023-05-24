package com.example.castudy_module_4.model.product;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name_product;
    private Double price;
    private Integer quantity;
    private String img;


    private Date EXP;
    private Date MFG;

    @Column(name = "exp")
    private String EXP;
    @Column(name = "mfg")
    private String MFG;

    private Double weight;

    private String descriptions;

    @ManyToOne
    @JoinColumn(name = "id_type_product", referencedColumnName = "idTypeProduct")
    private TypeProduct typeProduct;

    public Product() {
    }


    public Product(Integer id, String name_product, Double price, String img, Date EXP, Date MFG, Double weight, String descriptions, TypeProduct typeProduct) {

    public Product(Integer id, String name, Double price, Integer quantity, String img, String EXP, String MFG, Double weight, String describe, TypeProduct typeProduct) {

        this.id = id;
        this.name_product = name_product;
        this.price = price;
        this.quantity = quantity;
        this.img = img;
        this.EXP = EXP;
        this.MFG = MFG;
        this.weight = weight;
        this.descriptions = descriptions;
        this.typeProduct = typeProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEXP() {
        return EXP;
    }

    public void setEXP(String EXP) {
        this.EXP = EXP;
    }

    public String getMFG() {
        return MFG;
    }

    public void setMFG(String MFG) {
        this.MFG = MFG;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

}
