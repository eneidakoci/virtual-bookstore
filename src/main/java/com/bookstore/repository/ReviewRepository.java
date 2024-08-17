package com.bookstore.repository;

import com.bookstore.domain.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
