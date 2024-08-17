package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.RoleDto;
import com.bookstore.domain.dto.RoleRequest;
import com.bookstore.domain.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public static RoleDto toDto(RoleEntity entity) {
        if (entity == null) {
            return null;
        }

        RoleDto roleDto = new RoleDto();
        roleDto.setId(entity.getId());
        roleDto.setName(entity.getName());
        roleDto.setUser(entity.getUser());

        return roleDto;
    }

    public static RoleEntity toEntity(RoleDto dto) {
        if (dto == null) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(dto.getId());
        roleEntity.setName(dto.getName());
        roleEntity.setUser(dto.getUser());

        return roleEntity;
    }

    public static RoleEntity roleRequestToEntity(RoleRequest request) {
        if (request == null) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(request.getName());
        roleEntity.setUser(request.getUser());

        return roleEntity;
    }
}
