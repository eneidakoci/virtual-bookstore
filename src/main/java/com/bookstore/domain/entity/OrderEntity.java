package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> items;

    @Column(name = "total")
    private Double total;
}
