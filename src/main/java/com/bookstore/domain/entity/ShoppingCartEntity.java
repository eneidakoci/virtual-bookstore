package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    private List<CartItemEntity> items;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
