package com.bookstore.domain.dto;

import com.bookstore.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private UserEntity user;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private List<OrderItemDto> orderItems;
    private String status;
    private Long userId;


}
