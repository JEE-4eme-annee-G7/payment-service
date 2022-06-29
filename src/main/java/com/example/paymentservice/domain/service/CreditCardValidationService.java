package com.example.paymentservice.domain.service;

import com.example.paymentservice.domain.entity.Buyer;
import com.example.paymentservice.domain.entity.CreditCard;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
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

    public Boolean expirationDateValidation(CreditCard creditCard){
        if (creditCard.getExpirationDate() == null)
            return false;
        return !creditCard.getExpirationDate().before(new Date());
    }


    public Boolean isValid(CreditCard creditCard, Buyer buyer){
        return numberValidation(creditCard)
                && cryptogramValidation(creditCard)
                && ownerValidation(creditCard, buyer)
                && expirationDateValidation(creditCard);
    }
}
