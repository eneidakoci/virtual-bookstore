package com.bookstore.service.impl;

import com.bookstore.domain.dto.ReviewDto;
import com.bookstore.domain.dto.ReviewRequest;
import com.bookstore.domain.entity.ReviewEntity;
import com.bookstore.domain.mapper.ReviewMapper;
import com.bookstore.repository.ReviewRepository;
import com.bookstore.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public ReviewDto createReview(ReviewRequest request) {
        ReviewEntity reviewEntity = reviewMapper.reviewRequestToEntity(request);
        reviewEntity = reviewRepository.save(reviewEntity);
        return ReviewMapper.toDto(reviewEntity);
    }

    @Override
    public ReviewDto updateReview(Long id, ReviewRequest request) {
        ReviewEntity existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id: " + id));

        existingReview.setRating(request.getRating());
        existingReview.setReviewText(request.getReviewText());
        ReviewEntity updatedReview = reviewRepository.save(existingReview);
        return ReviewMapper.toDto(updatedReview);
    }

    @Override
    public void deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Review not found with id: " + id);
        }
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        ReviewEntity reviewEntity = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found with id: " + id));
        return ReviewMapper.toDto(reviewEntity);
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        List<ReviewEntity> reviewEntities = reviewRepository.findAll();
        return reviewEntities.stream()
                .map(ReviewMapper::toDto)
                .toList();
    }
}
