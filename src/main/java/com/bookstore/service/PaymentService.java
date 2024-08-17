package com.bookstore.service;

import com.bookstore.domain.dto.PaymentDto;
import com.bookstore.domain.dto.PaymentRequest;
import com.bookstore.domain.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    PaymentDto createPayment(PaymentRequest request);
    PaymentDto updatePayment(Long id, PaymentRequest request);
    void deletePayment(Long id);
    PaymentDto getPaymentById(Long id);
    List<PaymentDto> getAllPayments();
}
