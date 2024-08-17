package com.bookstore.controller;

import com.bookstore.domain.dto.ReviewDto;
import com.bookstore.domain.dto.ReviewRequest;
import com.bookstore.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDto>> findAllReviews() {
        List<ReviewDto> reviewDtos = reviewService.getAllReviews();
        if (reviewDtos == null) {
            throw new EntityNotFoundException("Reviews not found.");
        }
        return ResponseEntity.ok(reviewDtos);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> findReviewById(@PathVariable Long reviewId) {
        ReviewDto reviewDto = reviewService.getReviewById(reviewId);
        if (reviewDto != null) {
            return ResponseEntity.ok(reviewDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewRequest reviewRequest) {
        ReviewDto createdReview = reviewService.createReview(reviewRequest);
        if (createdReview != null) {
            URI locationOfCreatedReview = URI.create("/api/reviews/" + createdReview.getId());
            return ResponseEntity.created(locationOfCreatedReview).body(createdReview);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long reviewId,
                                                  @RequestBody ReviewRequest reviewRequest) {
        ReviewDto updatedReview = reviewService.updateReview(reviewId, reviewRequest);
        if (updatedReview != null) {
            return ResponseEntity.ok(updatedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
