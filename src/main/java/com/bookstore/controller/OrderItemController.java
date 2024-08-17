package com.bookstore.controller;

import com.bookstore.domain.dto.OrderItemDto;
import com.bookstore.domain.dto.OrderItemRequest;
import com.bookstore.service.OrderItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> findAllOrderItems() {
        List<OrderItemDto> orderItemDtos = orderItemService.getAllOrderItems();
        if (orderItemDtos == null) {
            throw new EntityNotFoundException("Order items not found.");
        }
        return ResponseEntity.ok(orderItemDtos);
    }

    @GetMapping("/{orderItemId}")
    public ResponseEntity<OrderItemDto> findOrderItemById(@PathVariable Long orderItemId) {
        OrderItemDto orderItemDto = orderItemService.getOrderItemById(orderItemId);
        if (orderItemDto != null) {
            return ResponseEntity.ok(orderItemDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody OrderItemRequest orderItemRequest) {
        OrderItemDto createdOrderItem = orderItemService.createOrderItem(null, orderItemRequest);
        if (createdOrderItem != null) {
            URI locationOfCreatedOrderItem = URI.create("/api/order-items/" + createdOrderItem.getId());
            return ResponseEntity.created(locationOfCreatedOrderItem).body(createdOrderItem);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{orderItemId}")
    public ResponseEntity<OrderItemDto> updateOrderItem(@PathVariable Long orderItemId,
                                                        @RequestBody OrderItemRequest orderItemRequest) {
        OrderItemDto updatedOrderItem = orderItemService.updateOrderItem(orderItemId, orderItemRequest);
        if (updatedOrderItem != null) {
            return ResponseEntity.ok(updatedOrderItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}
