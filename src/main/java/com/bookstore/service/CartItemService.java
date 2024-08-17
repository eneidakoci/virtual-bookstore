package com.bookstore.service;


import com.bookstore.domain.dto.CartItemDto;
import com.bookstore.domain.dto.CartItemRequest;
import com.bookstore.domain.entity.CartItemEntity;
import com.bookstore.domain.entity.ShoppingCartEntity;

import java.util.List;

public interface CartItemService {
    CartItemDto createCartItem(CartItemRequest request, ShoppingCartEntity shoppingCart);
    CartItemDto updateCartItem(Long id, CartItemDto cartItemDto);
    void deleteCartItem(Long id);
    CartItemDto getCartItemById(Long id);
    List<CartItemDto> getAllCartItems();
}
