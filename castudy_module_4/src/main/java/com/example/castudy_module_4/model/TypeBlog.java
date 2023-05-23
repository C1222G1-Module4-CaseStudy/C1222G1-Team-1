package com.example.castudy_module_4.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.List;

@Controller
@Table(name = "type_blog")
public class TypeBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBlog;

    @OneToMany(mappedBy = "typeBlog")
    private List<Blog> blogList;
}
