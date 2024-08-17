package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.CategoryDto;
import com.bookstore.domain.dto.CategoryRequest;
import com.bookstore.domain.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public static CategoryDto toDto(CategoryEntity entity) {
        if (entity == null) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(entity.getId());
        categoryDto.setName(entity.getName());

        return categoryDto;
    }

    public static CategoryEntity toEntity(CategoryDto dto) {
        if (dto == null) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(dto.getId());
        categoryEntity.setName(dto.getName());

        return categoryEntity;
    }

    public static CategoryEntity categoryRequestToEntity(CategoryRequest request) {
        if (request == null) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(request.getName());

        return categoryEntity;
    }
}
