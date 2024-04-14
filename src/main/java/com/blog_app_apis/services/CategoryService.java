package com.blog_app_apis.services;

import com.blog_app_apis.entities.Category;
import com.blog_app_apis.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

//    create
    CategoryDto createCategory(CategoryDto categoryDto);
//    update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
//    getById
    CategoryDto getCategoryById(Integer categoryId);
//    getAll
    List<CategoryDto> getAllCategory();
//    delete
    void deleteById(Integer categoryId);
}
