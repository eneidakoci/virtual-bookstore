package com.bookstore.controller;

import com.bookstore.domain.dto.OrderDto;
import com.bookstore.domain.dto.OrderRequest;
import com.bookstore.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAllOrders() {
        List<OrderDto> orderDtos = orderService.getAllOrders();
        if (orderDtos == null) {
            throw new EntityNotFoundException("Orders not found.");
        }
        return ResponseEntity.ok(orderDtos);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> findOrderById(@PathVariable Long orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderDto createdOrder = orderService.createOrder(orderRequest, null);
        if (createdOrder != null) {
            URI locationOfCreatedOrder = URI.create("/api/orders/" + createdOrder.getId());
            return ResponseEntity.created(locationOfCreatedOrder).body(createdOrder);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long orderId,
                                                @RequestBody OrderRequest orderRequest) {
        OrderDto updatedOrder = orderService.updateOrder(orderId, orderRequest);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
