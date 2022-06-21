package com.example.paymentservice.domain;

import com.example.paymentservice.domain.entity.Payment;
import com.example.paymentservice.domain.entity.PaymentStatus;

public interface PaymentDAO {

    void savePayment(Payment payment, PaymentStatus status);
    boolean exist(String checkoutId);
    PaymentStatus getByCheckoutId(String checkoutId);
    void update(Payment payment, PaymentStatus status);
    void delete(String id);
}
