package com.bookstore.domain.dto;

import com.bookstore.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {
    private Long id;
    private UserEntity user;
    private List<CartItemDto> cartItems;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "ShoppingCartDto{" +
                "id=" + id +
                ", user=" + user +
                ", cartItems=" + cartItems +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartDto that = (ShoppingCartDto) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(cartItems, that.cartItems) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, cartItems, createdAt);
    }
}
