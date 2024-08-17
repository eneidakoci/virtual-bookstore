package com.bookstore.domain.dto;

import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.entity.ShoppingCartEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private BookEntity book;
    private ShoppingCartEntity shoppingCart;
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemDto that = (CartItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(shoppingCart, that.shoppingCart) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, shoppingCart, quantity);
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "id=" + id +
                ", book=" + book +
                ", shoppingCart=" + shoppingCart +
                ", quantity=" + quantity +
                '}';
    }
}
