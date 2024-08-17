package com.bookstore.domain.dto;

import com.bookstore.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartRequest {
    private UserEntity user;
    private List<CartItemRequest> cartItems;
    private LocalDateTime createdAt;
}
