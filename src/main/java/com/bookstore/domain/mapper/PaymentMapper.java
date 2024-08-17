package com.bookstore.domain.mapper;

import com.bookstore.domain.dto.PaymentDto;
import com.bookstore.domain.dto.PaymentRequest;
import com.bookstore.domain.entity.PaymentEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public static PaymentDto toDto(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(entity.getId());
        paymentDto.setOrder(entity.getOrder());
        paymentDto.setAmount(entity.getAmount());
        paymentDto.setMethod(entity.getMethod());
        paymentDto.setPaymentDate(entity.getPaymentDate());

        return paymentDto;
    }

    public static PaymentEntity toEntity(PaymentDto dto) {
        if (dto == null) {
            return null;
        }

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(dto.getId());
        paymentEntity.setOrder(dto.getOrder());
        paymentEntity.setAmount(dto.getAmount());
        paymentEntity.setMethod(dto.getMethod());
        paymentEntity.setPaymentDate(dto.getPaymentDate());

        return paymentEntity;
    }

    public static PaymentEntity paymentRequestToEntity(PaymentRequest request) {
        if (request == null) {
            return null;
        }

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setOrder(request.getOrder());
        paymentEntity.setAmount(request.getAmount());
        paymentEntity.setMethod(request.getMethod());
        paymentEntity.setPaymentDate(request.getPaymentDate());

        return paymentEntity;
    }
}
