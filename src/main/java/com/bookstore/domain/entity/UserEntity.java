package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;
    private String password;
    private String email;
    private Boolean enabled;
    private String address;

    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private ShoppingCartEntity shoppingCart;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;
}
