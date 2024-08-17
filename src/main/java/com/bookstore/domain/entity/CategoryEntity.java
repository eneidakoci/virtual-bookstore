package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}
