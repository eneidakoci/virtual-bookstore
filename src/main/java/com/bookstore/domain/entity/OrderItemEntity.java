package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    private int quantity;

    @Column(name = "price")
    private Double price;
}
