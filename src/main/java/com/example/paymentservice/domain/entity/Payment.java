package com.example.paymentservice.domain.entity;

import java.util.Objects;

public class Payment {
    private Buyer buyer;
    private String checkout_id;
    private Double amount;


    public Buyer getBuyer() {
        return buyer;
    }

    public Payment setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public String getCheckout_id() {
        return checkout_id;
    }

    public Payment setCheckout_id(String checkout_id) {
        this.checkout_id = checkout_id;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Payment setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "buyer=" + buyer +
                ", checkout_id='" + checkout_id + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(buyer, payment.buyer) && Objects.equals(checkout_id, payment.checkout_id) && Objects.equals(amount, payment.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyer, checkout_id, amount);
    }
}
