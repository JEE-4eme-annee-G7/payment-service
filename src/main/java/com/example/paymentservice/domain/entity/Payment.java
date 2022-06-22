package com.example.paymentservice.domain.entity;

public class Payment {
    private final Buyer buyer;
    private final String checkout_id;
    private final Double amount;

    public Payment(Buyer buyer, String checkout_id, Double amount) {
        this.buyer = buyer;
        this.checkout_id = checkout_id;
        this.amount = amount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public String getCheckout_id() {
        return checkout_id;
    }

    public Double getAmount() {
        return amount;
    }
}
