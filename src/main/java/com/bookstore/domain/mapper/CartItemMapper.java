package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.CartItemDto;
import com.bookstore.domain.dto.CartItemRequest;
import com.bookstore.domain.entity.BookEntity;
import com.bookstore.domain.entity.CartItemEntity;
import com.bookstore.domain.entity.ShoppingCartEntity;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {

    private final BookRepository bookRepository;

    @Autowired
    public CartItemMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public CartItemDto toDto(CartItemEntity cartItemEntity) {
        if (cartItemEntity == null) {
            return null;
        }

        return new CartItemDto(
                cartItemEntity.getId(),
                cartItemEntity.getBook(),
                cartItemEntity.getShoppingCart(),
                cartItemEntity.getQuantity()
        );
    }

    public CartItemEntity toEntity(CartItemDto cartItemDto, ShoppingCartEntity shoppingCart) {
        if (cartItemDto == null) {
            return null;
        }

        BookEntity book = bookRepository.findById(cartItemDto.getBook().getId())
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + cartItemDto.getBook().getId()));

        return new CartItemEntity(
                cartItemDto.getId(), //use the ID from the DTO
                shoppingCart,
                book,
                cartItemDto.getQuantity()
        );
    }

    public CartItemEntity cartItemRequestToEntity(CartItemRequest request, ShoppingCartEntity shoppingCart) {
        if (request == null) {
            return null;
        }

        BookEntity book = bookRepository.findById(request.getBook().getId())
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + request.getBook().getId()));

        return new CartItemEntity(
                null, //Id will be generated on its own
                shoppingCart,
                book,
                request.getQuantity()
        );
    }

}
