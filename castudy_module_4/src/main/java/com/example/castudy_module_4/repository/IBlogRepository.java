package com.example.castudy_module_4.repository;

import com.example.castudy_module_4.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository implements JpaRepository<Blog, int> {
}
