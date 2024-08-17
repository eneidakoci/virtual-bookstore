package com.bookstore.repository;

import com.bookstore.domain.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}
