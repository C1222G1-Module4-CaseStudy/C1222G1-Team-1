package com.example.castudy_module_4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_role",
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name") })

public class Role {
    @Id
    private  int id;
    private String name;
    @OneToMany(mappedBy = "employeeType")
    private List<Users> employees;

    public Role() {
    }

    public Role(int id, String name, List<Users> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Users> employees) {
        this.employees = employees;
    }
}
