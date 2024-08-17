package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.OrderDto;
import com.bookstore.domain.dto.OrderRequest;
import com.bookstore.domain.entity.OrderEntity;
import com.bookstore.domain.entity.OrderItemEntity;
import com.bookstore.domain.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public static OrderDto toDto(OrderEntity entity) {
        if (entity == null) {
            return null;
        }

        OrderDto orderDto = new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setUser(entity.getUser());
        orderDto.setOrderDate(entity.getOrderDate());
        orderDto.setStatus(entity.getStatus());
        orderDto.setTotalAmount(entity.getItems().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum());
        orderDto.setOrderItems(entity.getItems().stream().map(OrderItemMapper::toDto).collect(Collectors.toList()));
        orderDto.setUserId(entity.getUser().getId());

        return orderDto;
    }

    public static OrderEntity orderDtoToEntity(OrderDto dto, UserEntity userEntity) {
        if (dto == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setOrderDate(dto.getOrderDate());
        entity.setStatus(dto.getStatus());
        entity.setUser(userEntity);
        entity.setItems(dto.getOrderItems().stream().map(OrderItemMapper::orderItemDtoToEntity).collect(Collectors.toList()));
        entity.setTotal(dto.getTotalAmount());
        return entity;
    }

    public static OrderEntity orderRequestToEntity(OrderRequest request, UserEntity userEntity) {
        if (request == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setOrderDate(request.getOrderDate());
        entity.setStatus(request.getStatus());
        entity.setUser(userEntity);
        entity.setTotal(request.getTotalAmount());

        List<OrderItemEntity> orderItems = request.getOrderItems().stream()
                .map(req -> {
                    OrderItemEntity orderItemEntity = OrderItemMapper.orderItemRequestToEntity(new OrderItemEntity().getOrder(), req);
                    orderItemEntity.setOrder(entity);
                    return orderItemEntity;
                })
                .collect(Collectors.toList());

        entity.setItems(orderItems);

        return entity;
    }
}
