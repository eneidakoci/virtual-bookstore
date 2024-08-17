package com.bookstore.service.impl;

import com.bookstore.domain.dto.OrderItemDto;
import com.bookstore.domain.dto.OrderItemRequest;
import com.bookstore.domain.entity.OrderEntity;
import com.bookstore.domain.entity.OrderItemEntity;
import com.bookstore.domain.mapper.OrderItemMapper;
import com.bookstore.repository.OrderItemRepository;
import com.bookstore.service.OrderItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItemDto createOrderItem(OrderEntity orderEntity,OrderItemRequest request) {
        OrderItemEntity orderItemEntity = OrderItemMapper.orderItemRequestToEntity(orderEntity,request);
        orderItemEntity = orderItemRepository.save(orderItemEntity);
        return OrderItemMapper.toDto(orderItemEntity);
    }

    @Override
    public OrderItemDto updateOrderItem(Long id, OrderItemRequest request) {
        OrderItemEntity existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OrderItem not found with id: " + id));

        existingOrderItem.setQuantity(request.getQuantity());
        existingOrderItem.setPrice(request.getPrice());
        OrderItemEntity updatedOrderItem = orderItemRepository.save(existingOrderItem);
        return OrderItemMapper.toDto(updatedOrderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("OrderItem not found with id: " + id);
        }
    }

    @Override
    public OrderItemDto getOrderItemById(Long id) {
        OrderItemEntity orderItemEntity = orderItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OrderItem not found with id: " + id));
        return OrderItemMapper.toDto(orderItemEntity);
    }

    @Override
    public List<OrderItemDto> getAllOrderItems() {
        List<OrderItemEntity> orderItemEntities = orderItemRepository.findAll();
        return orderItemEntities.stream()
                .map(OrderItemMapper::toDto)
                .toList();
    }
}
