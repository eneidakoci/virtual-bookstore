package com.bookstore.service.impl;

import com.bookstore.domain.dto.CategoryDto;
import com.bookstore.domain.dto.CategoryRequest;
import com.bookstore.domain.entity.CategoryEntity;
import jakarta.persistence.EntityNotFoundException;
import com.bookstore.domain.mapper.CategoryMapper;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
        return CategoryMapper.toDto(category);
    }

    @Override
    public CategoryDto createCategory(CategoryRequest request) {
        CategoryEntity category = CategoryMapper.categoryRequestToEntity(request);
        category = categoryRepository.save(category);
        return CategoryMapper.toDto(category);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryRequest request) {
        CategoryEntity existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));

        existingCategory.setName(request.getName());
        CategoryEntity updatedCategory = categoryRepository.save(existingCategory);
        return CategoryMapper.toDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Category not found with id: " + id);
        }
    }
}
