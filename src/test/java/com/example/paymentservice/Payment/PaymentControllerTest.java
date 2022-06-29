package com.example.paymentservice.Payment;

import com.example.paymentservice.domain.entity.Buyer;
import com.example.paymentservice.domain.entity.CreditCard;
import com.example.paymentservice.infrastructure.web.request.PaymentRequest;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PaymentControllerTest {

    @LocalServerPort
    int port;


    public Buyer buyer_valid = new Buyer();
    public Buyer buyer_not_valid = new Buyer();
    public CreditCard creditCard_valid = new CreditCard();
    public CreditCard creditCard_not_valid = new CreditCard();
    public PaymentRequest paymentRequest_valid = new PaymentRequest();
    public PaymentRequest paymentRequest_not_valid = new PaymentRequest();

    @BeforeEach
    void setup(){
        RestAssured.port = port;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());


        creditCard_valid.setNumber("2568295061084754")
                .setCryptogram("900")
                .setOwnerLastname("bervin")
                .setExpirationDate(new Date(2025, Calendar.DECEMBER, 25));

        buyer_valid.setId(1).setEmail("kelyan.bervin@gmail.com")
                .setFirstname("kelyan")
                .setLastname("bervin")
                .setCreditCard(creditCard_valid);

        paymentRequest_valid.setBuyer(buyer_valid)
                .setCheckout_id(UUID.randomUUID().toString())
                .setAmount(199.95);




        creditCard_not_valid.setNumber("20084754")
                .setCryptogram("9")
                .setOwnerLastname("bervin");

        buyer_not_valid.setId(1).setEmail("kelyan.bervin@gmail.com")
                .setFirstname("kelyan")
                .setLastname("bervin")
                .setCreditCard(creditCard_not_valid);

        paymentRequest_not_valid.setBuyer(buyer_not_valid)
                .setCheckout_id(UUID.randomUUID().toString())
                .setAmount(199.95);
    }


    @Test
    public void shouldAcceptPayment(){

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(paymentRequest_valid)
                .post("/payment")
                .then()
                .statusCode(202);
    }

    @Test
    public void shouldRefusePaymentWithBadRequest(){

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(paymentRequest_not_valid)
                .post("/payment")
                .then()
                .statusCode(400);
    }









}
