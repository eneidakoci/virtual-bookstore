package com.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bookstore.domain.dto.CategoryDto;
import com.bookstore.domain.dto.CategoryRequest;
import com.bookstore.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAllCategories() {
        List<CategoryDto> categoryDtos = categoryService.getAllCategories();
        if (categoryDtos == null) {
            throw new EntityNotFoundException("Categories not found.");
        }
        return ResponseEntity.ok(categoryDtos);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable Long categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        if (categoryDto != null) {
            return ResponseEntity.ok(categoryDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryDto createdCategory = categoryService.createCategory(categoryRequest);
        if (createdCategory != null) {
            URI locationOfCreatedCategory = URI.create("/api/categories/" + createdCategory.getId());
            return ResponseEntity.created(locationOfCreatedCategory).body(createdCategory);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long categoryId,
                                                      @RequestBody CategoryRequest categoryRequest) {
        CategoryDto updatedCategory = categoryService.updateCategory(categoryId, categoryRequest);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
