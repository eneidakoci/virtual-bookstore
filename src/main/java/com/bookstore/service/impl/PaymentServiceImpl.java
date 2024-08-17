package com.bookstore.service.impl;

import com.bookstore.domain.dto.PaymentDto;
import com.bookstore.domain.dto.PaymentRequest;
import com.bookstore.domain.entity.PaymentEntity;
import com.bookstore.domain.mapper.PaymentMapper;
import com.bookstore.repository.PaymentRepository;
import com.bookstore.service.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentDto createPayment(PaymentRequest request) {
        PaymentEntity paymentEntity = paymentMapper.paymentRequestToEntity(request);
        paymentEntity = paymentRepository.save(paymentEntity);
        return PaymentMapper.toDto(paymentEntity);
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentRequest request) {
        PaymentEntity existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + id));

        existingPayment.setAmount(request.getAmount());
        existingPayment.setMethod(request.getMethod());
        PaymentEntity updatedPayment = paymentRepository.save(existingPayment);
        return PaymentMapper.toDto(updatedPayment);
    }

    @Override
    public void deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Payment not found with id: " + id);
        }
    }

    @Override
    public PaymentDto getPaymentById(Long id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + id));
        return PaymentMapper.toDto(paymentEntity);
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        List<PaymentEntity> paymentEntities = paymentRepository.findAll();
        return paymentEntities.stream()
                .map(PaymentMapper::toDto)
                .toList();
    }
}
