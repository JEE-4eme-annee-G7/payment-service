package com.example.paymentservice.domain.service;

import com.example.paymentservice.infrastructure.web.request.PaymentRequest;
import org.springframework.stereotype.Service;


@Service
public class PaymentValidationService {

    private final CreditCardValidationService creditCardValidationService;

    public PaymentValidationService(CreditCardValidationService creditCardValidationService) {
        this.creditCardValidationService = creditCardValidationService;
    }

    public boolean isValid(PaymentRequest payment){
        return creditCardValidationService.isValid(payment.getBuyer().getCreditCard(), payment.getBuyer());
    }
}
