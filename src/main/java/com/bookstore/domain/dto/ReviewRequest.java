package com.bookstore.domain.dto;

import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private UserEntity user;
    private BookEntity book;
    private String reviewText;
    private Integer rating;
    private LocalDateTime reviewDate;

}
