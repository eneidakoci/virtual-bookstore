package com.bookstore.domain.dto;

import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {

    private BookEntity book;
    private OrderEntity order;
    private Integer quantity;
    private Double price;
}
