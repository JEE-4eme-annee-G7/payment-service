package com.example.paymentservice.domain.mapper;

import com.example.paymentservice.domain.entity.Payment;
import com.example.paymentservice.infrastructure.web.request.PaymentRequest;
import com.example.paymentservice.infrastructure.web.response.PaymentResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public PaymentRequest toRequest(Payment payment){
        return new PaymentRequest()
                .setBuyer(payment.getBuyer())
                .setCheckout_id(payment.getCheckout_id())
                .setAmount(payment.getAmount());
    }

    public PaymentResponse toResponse(Payment payment){
        return new PaymentResponse()
                .setBuyer(payment.getBuyer())
                .setCheckout_id(payment.getCheckout_id())
                .setAmount(payment.getAmount());
    }

    public Payment toEntity(PaymentRequest paymentRequest) {
        return new Payment()
                .setBuyer(paymentRequest.getBuyer())
                .setCheckout_id(paymentRequest.getCheckout_id())
                .setAmount(paymentRequest.getAmount());
    }
}
