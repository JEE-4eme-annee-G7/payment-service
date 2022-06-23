package com.example.paymentservice.domain.service;

import com.example.paymentservice.domain.entity.Buyer;
import com.example.paymentservice.domain.entity.CreditCard;

import java.util.Date;
import java.util.Objects;

public class CreditCardValidationService {


    public Boolean numberValidation(CreditCard creditCard){
        return creditCard.getNumber().length() == 16;
    }

    public Boolean cryptogramValidation(CreditCard creditCard){
        return creditCard.getCryptogram().length() == 3;
    }

    public Boolean ownerValidation(CreditCard creditCard, Buyer buyer){
        return Objects.equals(creditCard.getOwnerLastname(), buyer.getLastname());
    }
    //TODO : A tester
    public Boolean expirationDateValidation(CreditCard creditCard){
        return !creditCard.getExpirationDate().before(new Date());
    }


    public Boolean isValid(CreditCard creditCard, Buyer buyer){
        return !numberValidation(creditCard)
                || cryptogramValidation(creditCard)
                || ownerValidation(creditCard, buyer);
    }
}
