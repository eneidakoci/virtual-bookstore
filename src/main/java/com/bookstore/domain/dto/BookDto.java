package com.bookstore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private Double price;
    private String description;
    private String publisher;
    private LocalDate publishedDate;
    private Long categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) && Objects.equals(title, bookDto.title) && Objects.equals(author, bookDto.author) && Objects.equals(isbn, bookDto.isbn) && Objects.equals(price, bookDto.price) && Objects.equals(description, bookDto.description) && Objects.equals(publisher, bookDto.publisher) && Objects.equals(publishedDate, bookDto.publishedDate) && Objects.equals(categoryId, bookDto.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, isbn, price, description, publisher, publishedDate, categoryId);
    }


}
