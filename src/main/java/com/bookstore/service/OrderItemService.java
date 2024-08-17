package com.bookstore.service;

import com.bookstore.domain.dto.OrderItemDto;
import com.bookstore.domain.dto.OrderItemRequest;
import com.bookstore.domain.entity.OrderEntity;
import com.bookstore.domain.entity.OrderItemEntity;

import java.util.List;

public interface OrderItemService {
    OrderItemDto createOrderItem(OrderEntity orderEntity,OrderItemRequest request);
    OrderItemDto updateOrderItem(Long id, OrderItemRequest request);
    void deleteOrderItem(Long id);
    OrderItemDto getOrderItemById(Long id);
    List<OrderItemDto> getAllOrderItems();
}
