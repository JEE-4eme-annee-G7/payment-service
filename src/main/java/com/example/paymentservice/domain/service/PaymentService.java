package com.example.paymentservice.domain.service;


import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public void payment(String checkout_id){
        System.out.println("Paiement effectué");
    }

}
