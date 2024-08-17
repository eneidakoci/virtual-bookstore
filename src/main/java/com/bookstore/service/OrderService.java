package com.bookstore.service;

import com.bookstore.domain.dto.OrderDto;
import com.bookstore.domain.dto.OrderRequest;
import com.bookstore.domain.entity.OrderEntity;
import com.bookstore.domain.entity.UserEntity;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderRequest request, UserEntity userEntity);
    OrderDto updateOrder(Long id, OrderRequest request);
    void deleteOrder(Long id);
    OrderDto getOrderById(Long id);
    List<OrderDto> getAllOrders();
}
