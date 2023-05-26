package com.example.castudy_module_4.model;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_role")
public class Roles {

    @Id
    @GeneratedValue

    private int idRole;

    @Column(name = "name_role", length = 30, nullable = false)
    private String nameRole;
    @OneToMany(mappedBy = "users")
    List<UserRole> userRoles;

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
