package com.example.castudy_module_4.dto.employeeDTO;

import com.example.castudy_module_4.model.Users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserDTO {
    @NotBlank(message = "Không được để trống")
    private String fullName;
    @Email(message = "phải thuộc dạng email chuẩn xxx@gmail.com")
    private String email;
    @NotBlank(message = "Không được để trống")
    private String gender;
    @NotBlank(message = "Không được để trống ")
    private String address;
    @Pattern(regexp = "^0\\d{9}$",message = "Số điện thoại phải 0xxxxxxxxx")
    private String phoneNumber;
    private String image;
    @NotBlank(message = "Không được để trống")
    private String userName;
    @NotBlank(message = "Không được để trống")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String fullName, String email, String gender, String address, String phoneNumber, String image, String userName, String password) {
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.userName = userName;
        this.password = password;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
