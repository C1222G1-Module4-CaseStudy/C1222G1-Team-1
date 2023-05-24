package com.example.castudy_module_4.model;

import javax.persistence.*;

@Entity
@Table(name = "app_role")
public class Roles {

    @Id
    @GeneratedValue
    @Column(name = "id_role",nullable = false)
    private int idRole;

    @Column(name = "name_role", length = 30, nullable = false)
    private String nameRole;

    public Roles() {
    }

    public Roles(int idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
