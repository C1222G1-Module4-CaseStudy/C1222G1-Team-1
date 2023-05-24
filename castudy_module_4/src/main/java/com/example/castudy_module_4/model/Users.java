package com.example.castudy_module_4.model;

import javax.persistence.*;

@Entity
@Table(name = "users",
        uniqueConstraints = { //
        @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private String gender;
    private  String address;
    private String phoneNumber;
    private String image ;
    private String userName;
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private Role employeeType;
    public Users() {

    }

    public Users(int id, String fullName, String email, String gender, String address, String phoneNumber, String image, String userName, String password, Role employeeType) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.userName = userName;
        this.password = password;
        this.employeeType = employeeType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Role getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Role employeeType) {
        this.employeeType = employeeType;
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
}
