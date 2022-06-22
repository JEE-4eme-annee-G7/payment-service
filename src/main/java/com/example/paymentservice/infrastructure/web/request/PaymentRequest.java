package com.example.paymentservice.infrastructure.web.request;

import com.example.paymentservice.domain.entity.Buyer;

public class PaymentRequest {

    private Buyer buyer;
    private String checkout_id;
    private Double amount;

    public Buyer getBuyer() {
        return buyer;
    }

    public PaymentRequest setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public String getCheckout_id() {
        return checkout_id;
    }

    public PaymentRequest setCheckout_id(String checkout_id) {
        this.checkout_id = checkout_id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentRequest setAmount(Double amount) {
        this.amount = amount;
        return this;
    }
}
