package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.ReviewDto;
import com.bookstore.domain.dto.ReviewRequest;
import com.bookstore.domain.entity.ReviewEntity;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public static ReviewDto toDto(ReviewEntity entity) {
        if (entity == null) {
            return null;
        }

        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(entity.getId());
        reviewDto.setUser(entity.getUser());
        reviewDto.setBook(entity.getBook());
        reviewDto.setReviewText(entity.getReviewText());
        reviewDto.setRating(entity.getRating());
        reviewDto.setReviewDate(entity.getReviewDate());

        return reviewDto;
    }

    public static ReviewEntity toEntity(ReviewDto dto) {
        if (dto == null) {
            return null;
        }

        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setId(dto.getId());
        reviewEntity.setUser(dto.getUser());
        reviewEntity.setBook(dto.getBook());
        reviewEntity.setReviewText(dto.getReviewText());
        reviewEntity.setRating(dto.getRating());
        reviewEntity.setReviewDate(dto.getReviewDate());

        return reviewEntity;
    }

    public static ReviewEntity reviewRequestToEntity(ReviewRequest request) {
        if (request == null) {
            return null;
        }

        ReviewEntity reviewEntity = new ReviewEntity();
        reviewEntity.setUser(request.getUser());
        reviewEntity.setBook(request.getBook());
        reviewEntity.setReviewText(request.getReviewText());
        reviewEntity.setRating(request.getRating());
        reviewEntity.setReviewDate(request.getReviewDate());

        return reviewEntity;
    }
}
