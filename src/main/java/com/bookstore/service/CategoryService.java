package com.bookstore.service;

import com.bookstore.domain.dto.CategoryDto;
import com.bookstore.domain.dto.CategoryRequest;
import com.bookstore.domain.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    CategoryDto createCategory(CategoryRequest request);
    CategoryDto updateCategory(Long id, CategoryRequest request);
    void deleteCategory(Long id);
}
