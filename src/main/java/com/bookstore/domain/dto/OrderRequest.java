package com.bookstore.domain.dto;

import com.bookstore.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long userId;
    private List<OrderItemRequest> orderItems;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;
    private UserEntity user;
}
