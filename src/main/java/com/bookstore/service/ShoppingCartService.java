package com.bookstore.service;

import com.bookstore.domain.dto.ShoppingCartDto;
import com.bookstore.domain.dto.ShoppingCartRequest;
import com.bookstore.domain.entity.ShoppingCartEntity;
import com.bookstore.domain.entity.UserEntity;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCartDto createShoppingCart(ShoppingCartRequest request, UserEntity userEntity);
    ShoppingCartDto updateShoppingCart(Long id, ShoppingCartRequest request);
    void deleteShoppingCart(Long id);
    ShoppingCartDto getShoppingCartById(Long id);
    List<ShoppingCartDto> getAllShoppingCarts();
}
