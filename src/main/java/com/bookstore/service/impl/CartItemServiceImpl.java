package com.bookstore.service.impl;

import com.bookstore.domain.dto.CartItemDto;
import com.bookstore.domain.dto.CartItemRequest;
import com.bookstore.domain.entity.CartItemEntity;
import com.bookstore.domain.entity.ShoppingCartEntity;
import com.bookstore.domain.mapper.CartItemMapper;
import com.bookstore.repository.CartItemRepository;
import com.bookstore.service.CartItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartItemMapper cartItemMapper) {
        this.cartItemRepository = cartItemRepository;
        this.cartItemMapper = cartItemMapper;
    }

    @Override
    public CartItemDto createCartItem(CartItemRequest request, ShoppingCartEntity shoppingCart) {
        CartItemEntity cartItemEntity = cartItemMapper.cartItemRequestToEntity(request, shoppingCart);
        cartItemEntity = cartItemRepository.save(cartItemEntity);
        return cartItemMapper.toDto(cartItemEntity);
    }

//    @Override
//    public CartItemDto updateCartItem(Long id, CartItemRequest request) {
//        CartItemEntity existingCartItem = cartItemRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("CartItem not found with id: " + id));
//
//        // Update the cart item with request details
//        existingCartItem.setQuantity(request.getQuantity());
//        CartItemEntity updatedCartItem = cartItemRepository.save(existingCartItem);
//        return cartItemMapper.toDto(updatedCartItem);
//    }
    @Override
    public CartItemDto updateCartItem(Long id, CartItemDto cartItemDto) {
        Optional<CartItemEntity> cartItemOptional = cartItemRepository.findById(id);
        if (cartItemOptional.isPresent()) {
            CartItemEntity existingCartItem = cartItemOptional.get();
            existingCartItem.setShoppingCart(cartItemDto.getShoppingCart());
            existingCartItem.setQuantity(cartItemDto.getQuantity());
            existingCartItem.setBook(cartItemDto.getBook());
            CartItemEntity updatedCartItem = cartItemRepository.save(existingCartItem);
            return cartItemMapper.toDto(updatedCartItem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCartItem(Long id) {
        if (cartItemRepository.existsById(id)) {
            cartItemRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("CartItem not found with id: " + id);
        }
    }

    @Override
    public CartItemDto getCartItemById(Long id) {
        CartItemEntity cartItemEntity = cartItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CartItem not found with id: " + id));
        return cartItemMapper.toDto(cartItemEntity);
    }

    @Override
    public List<CartItemDto> getAllCartItems() {
        List<CartItemEntity> cartItemEntities = cartItemRepository.findAll();
        return cartItemEntities.stream()
                .map(cartItemMapper::toDto)
                .toList();
    }
}
