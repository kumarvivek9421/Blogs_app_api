package com.blog_app_apis.repositories;

import com.blog_app_apis.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category, Integer> {
}
