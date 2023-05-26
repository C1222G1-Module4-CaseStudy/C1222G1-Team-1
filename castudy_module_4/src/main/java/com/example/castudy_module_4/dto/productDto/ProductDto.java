package com.example.castudy_module_4.dto.productDto;

import com.example.castudy_module_4.model.product.TypeProduct;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class ProductDto implements Validator {
    private Integer id;
    @NotBlank(message = "Tên sản phẩm không được để trống!")
    private String name;

    @NotNull(message = "Giá không được để trống!")
    @DecimalMin("0.0")
    @DecimalMax(value = "99999.99")
//    @Pattern(regexp = "^\\d*(\\.\\d+)?$", message = "Amount must be a positive integer or decimal!")
    private Double price;
    @NotNull(message = "Số lượng không được để trống!")
    private Integer quantityStorage;
    //    @NotBlank(message = "Image cannot be blank!")
    @NotNull
    private String image;
    @NotNull(message = "Vui lòng không để trống!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date EXP;
    @NotNull(message = "Vui lòng không để trống!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date MFG;
    @NotNull(message = "Vui lòng nhập thông tin, không được để trống!")
    private Double weight;
    @NotBlank(message = "Vui lòng nhập thông tin, không được để trống!")
    private String describe;
    private TypeProduct typeProduct;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Double price, Integer quantityStorage, String image, Date EXP, Date MFG, Double weight, String describe, TypeProduct typeProduct) {
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

    public void setQuantityStorage(Integer quantity_storage) {
        this.quantityStorage = quantity_storage;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate EXP = LocalDate.parse((CharSequence) productDto.getEXP(), formatter);
            LocalDate MFG = LocalDate.parse((CharSequence) productDto.getMFG(), formatter);
            LocalDate now = LocalDate.now();
            int storageTime = Period.between(EXP,now).getDays();
            if (storageTime > 21) {
                errors.rejectValue("EXP", "EXP", "Rau củ quả đã hết hạn!");
            }
            ZoneId zoneId = ZoneId.systemDefault();
            productDto.setMFG(Date.from(MFG.atStartOfDay(zoneId).toInstant()));
        } catch (DateTimeParseException e) {
            errors.rejectValue("EXP", "EXP", "Không đúng định dạng vui lòng nhập lại!");
        }
    }
}
