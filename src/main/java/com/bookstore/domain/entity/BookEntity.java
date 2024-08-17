package com.bookstore.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "Book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private Double price;
    private String description;
    private String publisher;
    private LocalDate publishedDate;
    private Long categoryId;
}
