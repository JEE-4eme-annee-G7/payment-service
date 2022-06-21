package com.example.paymentservice.domain.entity;

public class CreditCard {

    String number;
    String cryptogram;
    String owner;

    public CreditCard(String number, String cryptogram, String owner) {
        this.number = number;
        this.cryptogram = cryptogram;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public CreditCard setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getCryptogram() {
        return cryptogram;
    }

    public CreditCard setCryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public CreditCard setOwner(String owner) {
        this.owner = owner;
        return this;
    }
}
