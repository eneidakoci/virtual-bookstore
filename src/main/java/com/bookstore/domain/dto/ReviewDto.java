package com.bookstore.domain.dto;

import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private UserEntity user;
    private BookEntity book;
    private String reviewText;
    private Integer rating;
    private LocalDateTime reviewDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDto reviewDto = (ReviewDto) o;
        return Objects.equals(id, reviewDto.id) && Objects.equals(user, reviewDto.user) && Objects.equals(book, reviewDto.book) && Objects.equals(reviewText, reviewDto.reviewText) && Objects.equals(rating, reviewDto.rating) && Objects.equals(reviewDate, reviewDto.reviewDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, book, reviewText, rating, reviewDate);
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "id=" + id +
                ", user=" + user +
                ", book=" + book +
                ", content='" + reviewText + '\'' +
                ", rating=" + rating +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
