package com.example.castudy_module_4.model.product;

import com.example.castudy_module_4.model.DetailBill;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

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

    @Column(name = "exp")
    private String EXP;
    @Column(name = "mfg")
    private String MFG;
    private Double weight;
    @Column(name = "descriptions")
    private String describe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_type_product")
    private TypeProduct typeProduct;
    @OneToMany(mappedBy = "product" ,cascade = CascadeType.ALL)
   private List<DetailBill> productList;

    public Product() {
    }


    public Product(Integer id, String name, Double price, Integer quantityStorage, String image, String EXP, String MFG, Double weight, String describe, TypeProduct typeProduct) {


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

    public List<DetailBill> getProductList() {
        return productList;
    }

    public void setProductList(List<DetailBill> productList) {
        this.productList = productList;
    }
}