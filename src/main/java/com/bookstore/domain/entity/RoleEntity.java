package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name")
    private String name;

    @OneToOne(mappedBy = "role")
    private UserEntity user;
}
