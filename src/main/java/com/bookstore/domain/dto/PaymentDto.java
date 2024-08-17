package com.bookstore.domain.dto;

import com.bookstore.domain.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private OrderEntity order;
    private Double amount;
    private String method;
    private LocalDateTime paymentDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDto that = (PaymentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(order, that.order) && Objects.equals(amount, that.amount) && Objects.equals(method, that.method) && Objects.equals(paymentDate, that.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, amount, method, paymentDate);
    }

    @Override
    public String toString() {
        return "PaymentDto{" +
                "id=" + id +
                ", order=" + order +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
