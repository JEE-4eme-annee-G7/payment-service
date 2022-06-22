package com.example.paymentservice.domain.entity;

import java.util.Objects;

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
