package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.ShoppingCartDto;
import com.bookstore.domain.dto.ShoppingCartRequest;
import com.bookstore.domain.entity.CartItemEntity;
import com.bookstore.domain.entity.ShoppingCartEntity;
import com.bookstore.domain.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoppingCartMapper {

    private static CartItemMapper cartItemMapper;

    @Autowired
    public ShoppingCartMapper(CartItemMapper cartItemMapper) {
        this.cartItemMapper = cartItemMapper;
    }

    public static ShoppingCartDto toDto(ShoppingCartEntity entity) {
        if (entity == null) {
            return null;
        }

        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        shoppingCartDto.setId(entity.getId());
        shoppingCartDto.setUser(entity.getUser());
        shoppingCartDto.setCartItems(entity.getItems().stream()
                .map(cartItemMapper::toDto)
                .collect(Collectors.toList()));

        return shoppingCartDto;
    }

    public ShoppingCartEntity toEntity(ShoppingCartDto dto) {
        if (dto == null) {
            return null;
        }

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setId(dto.getId());
        shoppingCartEntity.setUser(dto.getUser()); // Ensure this is a UserEntity

        // Convert CartItemDto to CartItemEntity
        shoppingCartEntity.setItems(dto.getCartItems().stream()
                .map(cartItemDto -> cartItemMapper.toEntity(cartItemDto, shoppingCartEntity)) // Adjust parameter types
                .collect(Collectors.toList())
        );

        return shoppingCartEntity;
    }

    public static ShoppingCartEntity shoppingCartRequestToEntity(ShoppingCartRequest request, UserEntity userEntity) {
        if (request == null) {
            return null;
        }

        ShoppingCartEntity shoppingCartEntity = new ShoppingCartEntity();
        shoppingCartEntity.setUser(userEntity);

        // Map each CartItemRequest to CartItemEntity
        List<CartItemEntity> cartItems = request.getCartItems().stream()
                .map(cartItemRequest -> cartItemMapper.cartItemRequestToEntity(cartItemRequest, shoppingCartEntity))
                .collect(Collectors.toList());
        shoppingCartEntity.setItems(cartItems);

        return shoppingCartEntity;
    }
}
