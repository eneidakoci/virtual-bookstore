package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_method")
    private String method;
}
