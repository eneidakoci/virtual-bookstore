package com.bookstore.domain.dto;

import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.entity.ShoppingCartEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequest {
    private BookEntity book;
    private ShoppingCartEntity shoppingCart;
    private Integer quantity;
}
