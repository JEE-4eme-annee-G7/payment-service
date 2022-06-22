package com.example.paymentservice.domain.service;

import com.example.paymentservice.domain.entity.Payment;
import com.example.paymentservice.infrastructure.web.request.PaymentRequest;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentValidationService {


    public boolean isValid(PaymentRequest payment){
        Random random = new Random();
        return random.nextBoolean();
    }
}
