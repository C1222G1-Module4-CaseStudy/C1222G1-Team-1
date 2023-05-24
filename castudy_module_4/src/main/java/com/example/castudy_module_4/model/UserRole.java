package com.example.castudy_module_4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "id_user", "id_role" }) })
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users appUser;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private Role appRole;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getAppUser() {
        return appUser;
    }

    public void setAppUser(Users appUser) {
        this.appUser = appUser;
    }

    public Role getAppRole() {
        return appRole;
    }

    public void setAppRole(Role appRole) {
        this.appRole = appRole;
    }
}
