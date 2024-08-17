package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.OrderItemDto;
import com.bookstore.domain.dto.OrderItemRequest;
import com.bookstore.domain.entity.OrderEntity;
import com.bookstore.domain.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public static OrderItemDto toDto(OrderItemEntity entity) {
        if (entity == null) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setBook(entity.getBook());
        orderItemDto.setId(entity.getId());
        orderItemDto.setOrder(entity.getOrder());
        orderItemDto.setQuantity(entity.getQuantity());
        orderItemDto.setPrice(entity.getPrice());

        return orderItemDto;
    }


    public static OrderItemEntity orderItemDtoToEntity(OrderItemDto dto) {
        if (dto == null) {
            return null;
        }

        OrderItemEntity entity = new OrderItemEntity();
        entity.setId(dto.getId());
        entity.setBook(dto.getBook());
        entity.setOrder(dto.getOrder());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());

        return entity;
    }

    public static OrderItemEntity orderItemRequestToEntity(OrderEntity orderEntity, OrderItemRequest request) {
        if (request == null || orderEntity == null) {
            return null;
        }

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setBook(request.getBook());
        orderItemEntity.setQuantity(request.getQuantity());
        orderItemEntity.setOrder(orderEntity);
        orderItemEntity.setPrice(request.getPrice());

        return orderItemEntity;
    }

}
