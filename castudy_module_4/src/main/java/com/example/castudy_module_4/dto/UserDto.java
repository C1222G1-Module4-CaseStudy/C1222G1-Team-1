package com.example.castudy_module_4.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDto {
//    @NotBlank(message = "Không được để trống")
    private int id;
    @NotBlank(message = "Không được để trống")
    private String fullName;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" , message = "Mời nhập đụng định dạng abc@gmail.com")
    @NotBlank(message = "Không được để trống")
    private String email;

    @NotBlank(message = "Không được để trống")
    private String gender;

    @NotBlank(message = "Không được để trống ")
    private String address;

    @Pattern(regexp = "^0\\d{9}$", message = "Số điện thoại phải 0xxxxxxxxx")
    private String phoneNumber;

    private String image;

    @NotBlank(message = "Không được để trống")
    private String userName;

    @NotBlank(message = "Không được để trống")
    private String password;

    @NotBlank(message = "Không được để trống ")
    private String country;

    @NotBlank(message = "Không được để trống ")
    private String dayOfBirth;

    @NotBlank(message = "Không được để trống ")
    private String description;

    public UserDto() {
    }

    public UserDto(String fullName, String email, String gender, String address, String phoneNumber, String image, String userName, String password, String country, String dayOfBirth, String description) {
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.dayOfBirth = dayOfBirth;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}