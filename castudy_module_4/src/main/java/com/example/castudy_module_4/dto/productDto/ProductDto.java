package com.example.castudy_module_4.dto.productDto;

import com.example.castudy_module_4.model.product.TypeProduct;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class ProductDto implements Validator {
    @NotBlank(message = "Tên sản phẩm không được để trống!")
    private String name;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax(value = "99999.99", message = "qq")
//    @Pattern(regexp = "^\\d*(\\.\\d+)?$", message = "Amount must be a positive integer or decimal!")
    private Double price;
    @NotNull(message = "Số lượng không được để trống!")
    private Integer quantityStorage;
    //    @NotBlank(message = "Image cannot be blank!")
    @NotNull
    private String image;
    @NotNull(message = "Vui lòng không để trống!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String EXP;
    @NotNull(message = "Vui lòng không để trống!")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String MFG;
    @NotNull(message = "Vui lòng nhập thông tin, không được để trống!")
    private Double weight;
    @NotBlank(message = "Vui lòng nhập thông tin, không được để trống!")
    private String describe;
    private TypeProduct typeProduct;

    public ProductDto() {
    }

    public ProductDto(String name, Double price, Integer quantityStorage, String image, String EXP, String MFG, Double weight, String describe, TypeProduct typeProduct) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate EXP = LocalDate.parse(productDto.getEXP(), formatter);
            LocalDate now = LocalDate.now();
            int storageTime = Period.between(EXP, now).getDays();
            if (storageTime > 21) {
                errors.rejectValue("EXP", "EXP", "Vegetables are overdue!");
            }
        } catch (DateTimeParseException e) {
            errors.rejectValue("EXP", "EXP", "Invalid date format, please check again!");
        }
    }
}
