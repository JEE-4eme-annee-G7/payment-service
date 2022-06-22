package com.example.paymentservice.domain.entity;

import java.util.Objects;

public class CreditCard {

    private String number;
    private String cryptogram;
    private String ownerLastname;


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

    public String getOwnerLastname() {
        return ownerLastname;
    }

    public CreditCard setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
        return this;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "number='" + number + '\'' +
                ", cryptogram='" + cryptogram + '\'' +
                ", owner='" + ownerLastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(number, that.number) && Objects.equals(cryptogram, that.cryptogram) && Objects.equals(ownerLastname, that.ownerLastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, cryptogram, ownerLastname);
    }
}
