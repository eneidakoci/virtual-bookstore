package com.bookstore.domain.dto;

import com.bookstore.domain.entity.RoleEntity;
import com.bookstore.domain.entity.ShoppingCartEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    private String address;
    private RoleEntity role;
    private ShoppingCartEntity shoppingCart;
}
