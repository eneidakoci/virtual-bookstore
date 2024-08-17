package com.bookstore.domain.dto;

import com.bookstore.domain.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private OrderEntity order;
    private Double amount;
    private String method;
    private LocalDateTime paymentDate;
}
