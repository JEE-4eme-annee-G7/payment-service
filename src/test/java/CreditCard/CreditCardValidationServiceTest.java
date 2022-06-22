package CreditCard;

import com.example.paymentservice.domain.entity.Buyer;
import com.example.paymentservice.domain.entity.CreditCard;
import com.example.paymentservice.domain.service.CreditCardValidationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardValidationServiceTest {


    private final CreditCardValidationService creditCardValidationService = new CreditCardValidationService();

    public CreditCard creditCard = new CreditCard()
            .setNumber("2568295061084754")
            .setCryptogram("900")
            .setOwnerLastname("bervin");

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
    void false_when_number_greater_than_16(){
        creditCard.setNumber("134398270925460983675463");
        assertTrue(creditCardValidationService.numberValidation(creditCard));
    }

    @Test
    void false_when_cryptogram_is_different_from_3(){
        creditCard.setCryptogram("124");
        assertFalse(creditCardValidationService.cryptogramValidation(creditCard));
    }
    

    @Test
    void false_when_buyerLastname_and_ownerLastname_are_different(){
        creditCard.setOwnerLastname("Macron");
        buyer.setLastname("Le Pen");
        assertFalse(creditCardValidationService.ownerValidation(creditCard, buyer));
    }
}
