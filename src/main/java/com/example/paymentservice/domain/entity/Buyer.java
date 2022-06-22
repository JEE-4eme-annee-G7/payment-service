package com.example.paymentservice.domain.entity;

import java.util.Objects;

public class Buyer {

    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private CreditCard creditCard;



    public int getId() {
        return id;
    }

    public Buyer setId(int id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Buyer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Buyer setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Buyer setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Buyer setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return id == buyer.id && Objects.equals(email, buyer.email) && Objects.equals(firstname, buyer.firstname) && Objects.equals(lastname, buyer.lastname) && Objects.equals(creditCard, buyer.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstname, lastname, creditCard);
    }
}
