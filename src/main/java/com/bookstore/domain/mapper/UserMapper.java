package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.UserDto;
import com.bookstore.domain.dto.UserRequest;
import com.bookstore.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toDto(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setUsername(entity.getUsername());
        userDto.setEmail(entity.getEmail());
        userDto.setEnabled(entity.getEnabled());
        userDto.setAddress(entity.getAddress());
        userDto.setRole(entity.getRole());
        userDto.setShoppingCart(entity.getShoppingCart());

        return userDto;
    }

    public static UserEntity toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.getId());
        userEntity.setUsername(dto.getUsername());
        userEntity.setEmail(dto.getEmail());
        userEntity.setEnabled(dto.getEnabled());
        userEntity.setAddress(dto.getAddress());
        userEntity.setRole(dto.getRole());
        userEntity.setShoppingCart(dto.getShoppingCart());

        return userEntity;
    }

    public static UserEntity userRequestToEntity(UserRequest request) {
        if (request == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(request.getPassword());
        userEntity.setEmail(request.getEmail());
        userEntity.setEnabled(request.getEnabled());
        userEntity.setAddress(request.getAddress());
        userEntity.setRole(request.getRole());
        userEntity.setShoppingCart(request.getShoppingCart());

        return userEntity;
    }
}
