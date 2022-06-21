package com.example.paymentservice.domain.entity;

public class Buyer {

    private int id;
    private String email;
    private String firstname;
    private String lastname;

    private CreditCard creditCard;

    public Buyer(int id, String email, String firstname, String lastname, CreditCard creditCard) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.creditCard = creditCard;
    }

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
}
