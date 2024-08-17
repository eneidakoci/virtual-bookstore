package com.bookstore.service;

import com.bookstore.domain.dto.ReviewDto;
import com.bookstore.domain.dto.ReviewRequest;
import com.bookstore.domain.entity.ReviewEntity;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(ReviewRequest request);
    ReviewDto updateReview(Long id, ReviewRequest request);
    void deleteReview(Long id);
    ReviewDto getReviewById(Long id);
    List<ReviewDto> getAllReviews();
}
