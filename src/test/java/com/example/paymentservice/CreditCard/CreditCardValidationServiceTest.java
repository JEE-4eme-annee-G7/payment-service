package com.example.paymentservice.CreditCard;

import com.example.paymentservice.domain.entity.Buyer;
import com.example.paymentservice.domain.entity.CreditCard;
import com.example.paymentservice.domain.service.CreditCardValidationService;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardValidationServiceTest {


    private final CreditCardValidationService creditCardValidationService = new CreditCardValidationService();

    public CreditCard creditCard = new CreditCard()
            .setNumber("2568295061084754")
            .setCryptogram("900")
            .setOwnerLastname("bervin")
            .setExpirationDate(new Date(2050, Calendar.DECEMBER, 25));

    public Buyer buyer = new Buyer()
            .setId(1).setEmail("kelyan.bervin@gmail.com")
            .setFirstname("kelyan")
            .setLastname("bervin")
            .setCreditCard(creditCard);


    @Test
    void credit_card_is_valid(){
        assertTrue(creditCardValidationService.isValid(creditCard, buyer));
    }

    @Test
    void false_when_number_different_than_16(){
        creditCard.setNumber("5463");
        assertFalse(creditCardValidationService.numberValidation(creditCard));
    }

    @Test
    void false_when_cryptogram_is_different_from_3(){
        creditCard.setCryptogram("1242");
        assertFalse(creditCardValidationService.cryptogramValidation(creditCard));
    }


    @Test
    void false_when_buyerLastname_and_ownerLastname_are_different(){
        creditCard.setOwnerLastname("Macron");
        buyer.setLastname("Le Pen");
        assertFalse(creditCardValidationService.ownerValidation(creditCard, buyer));
    }

    /*

    @Test
    void false_when_expiration_date_is_passed(){
        creditCard.setExpirationDate(new Date(2012, Calendar.JANUARY, 4));
        assertFalse(creditCardValidationService.ownerValidation(creditCard, buyer));
    }

     */
}
