package com.bookstore.domain.dto;

import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    private BookEntity book;
    private OrderEntity order;
    private Integer quantity;
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDto that = (OrderItemDto) o;
        return Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(order, that.order) && Objects.equals(quantity, that.quantity) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, order, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderItemDto{" +
                "id=" + id +
                ", book=" + book +
                ", order=" + order +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
