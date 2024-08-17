package com.bookstore.service.impl;

import com.bookstore.domain.dto.OrderDto;
import com.bookstore.domain.dto.OrderRequest;
import com.bookstore.domain.entity.OrderEntity;
import com.bookstore.domain.entity.UserEntity;
import com.bookstore.domain.mapper.OrderMapper;
import com.bookstore.repository.OrderRepository;
import com.bookstore.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto createOrder(OrderRequest request, UserEntity userEntity) {
        OrderEntity orderEntity = OrderMapper.orderRequestToEntity(request,userEntity);
        orderEntity = orderRepository.save(orderEntity);
        return OrderMapper.toDto(orderEntity);
    }

    @Override
    public OrderDto updateOrder(Long id, OrderRequest request) {
        OrderEntity existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));

        existingOrder.setStatus(request.getStatus());
        OrderEntity updatedOrder = orderRepository.save(existingOrder);
        return OrderMapper.toDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Order not found with id: " + id);
        }
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        return OrderMapper.toDto(orderEntity);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderEntities.stream()
                .map(OrderMapper::toDto)
                .toList();
    }
}
