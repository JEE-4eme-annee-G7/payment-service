package com.example.paymentservice.infrastructure.web.response;

import com.example.paymentservice.domain.entity.Buyer;

public class PaymentResponse {

    private Buyer buyer;
    private String checkout_id;
    private Double amount;

    public Buyer getBuyer() {
        return buyer;
    }

    public PaymentResponse setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public String getCheckout_id() {
        return checkout_id;
    }

    public PaymentResponse setCheckout_id(String checkout_id) {
        this.checkout_id = checkout_id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentResponse setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
