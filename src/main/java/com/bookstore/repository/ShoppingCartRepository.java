package com.bookstore.repository;

import com.bookstore.domain.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {
}
