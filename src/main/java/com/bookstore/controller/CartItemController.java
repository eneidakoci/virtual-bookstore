package com.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.domain.dto.CartItemDto;
import com.bookstore.domain.dto.CartItemRequest;
import com.bookstore.service.CartItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public ResponseEntity<List<CartItemDto>> findAllCartItems() {
        List<CartItemDto> cartItemDtos = cartItemService.getAllCartItems();
        if (cartItemDtos == null) {
            throw new EntityNotFoundException("Cart items not found.");
        }
        return ResponseEntity.ok(cartItemDtos);
    }

    @GetMapping("/{cartItemId}")
    public ResponseEntity<CartItemDto> findCartItemById(@PathVariable Long cartItemId) {
        CartItemDto cartItemDto = cartItemService.getCartItemById(cartItemId);
        if (cartItemDto != null) {
            return ResponseEntity.ok(cartItemDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CartItemDto> createCartItem(@RequestBody CartItemRequest cartItemRequest) {
        CartItemDto createdCartItem = cartItemService.createCartItem(cartItemRequest, null);
        if (createdCartItem != null) {
            URI locationOfCreatedCartItem = URI.create("/api/cartItems/" + createdCartItem.getId());
            return ResponseEntity.created(locationOfCreatedCartItem).body(createdCartItem);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItemDto> updateCartItem(@PathVariable Long cartItemId,
                                                      @RequestBody CartItemDto cartItemDto) {
        CartItemDto updatedCartItem = cartItemService.updateCartItem(cartItemId, cartItemDto);
        if (updatedCartItem != null) {
            return ResponseEntity.ok(updatedCartItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cartItemId}")
    public void deleteCartItem(@PathVariable Long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
    }
}
