package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCartEntity shoppingCart;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    private int quantity;

}
