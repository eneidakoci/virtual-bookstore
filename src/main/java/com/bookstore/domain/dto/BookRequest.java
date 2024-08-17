package com.bookstore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
    private String description;
    private Double price;
    private String publisher;
    private LocalDate publishedDate;
    private Long categoryId;
}
