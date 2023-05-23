package com.example.case_study.dto;

import com.example.case_study.model.EmployeeType;

public class EmployeeDTO {

    private String fullName;
    private String email;
    private String gender;
    private  String address;

    public EmployeeDTO() {
    }

    public EmployeeDTO( String fullName, String email, String gender, String address) {
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.address = address;
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


}
