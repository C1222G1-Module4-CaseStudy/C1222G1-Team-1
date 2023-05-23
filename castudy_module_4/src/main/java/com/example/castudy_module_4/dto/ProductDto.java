package com.example.castudy_module_4.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ProductDto implements Validator {
    @NotBlank(message = "Name cannot be engine!")
    private String name;
    @NotBlank(message = "Price cannot be blank!")
    @Pattern(regexp = "^\\d*(\\.\\d+)?$", message = "Amount must be a positive integer or decimal!")
    private Double price;
    @NotBlank(message = "EXP cannot be blank!")
    private String EXP;
    @NotBlank(message = "MFG cannot be blank!")
    private String MFG;
    @NotBlank(message = "Weight cannot be empty!!")
    @Size(min = 1)
    private Double weight;
    @NotBlank(message = "Describe cannot be empty!!")
    private String describe;

    public ProductDto() {
    }

    public ProductDto(String name, Double price, String EXP, String MFG, Double weight, String describe) {
        this.name = name;
        this.price = price;
        this.EXP = EXP;
        this.MFG = MFG;
        this.weight = weight;
        this.describe = describe;
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
