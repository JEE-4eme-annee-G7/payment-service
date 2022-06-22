package com.example.paymentservice.domain.service;

import com.example.paymentservice.domain.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentValidationService {


    public boolean isValid(Payment payment){
        Random random = new Random();
        return random.nextBoolean();
    }
}
