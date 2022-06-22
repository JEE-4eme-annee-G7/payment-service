package com.example.paymentservice.config;

import com.example.paymentservice.domain.PaymentDAO;
import com.example.paymentservice.domain.entity.Buyer;
import com.example.paymentservice.domain.entity.CreditCard;
import com.example.paymentservice.domain.entity.Payment;
import com.example.paymentservice.domain.entity.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RedisOperationsRunner implements CommandLineRunner {

    @Autowired
    private PaymentDAO paymentDAO;


    @Override
    public void run(String... args) throws Exception {

        var creditCard = new CreditCard()
                .setNumber("3849605736683950")
                .setCryptogram("900")
                .setOwnerLastname("bervin");;
        var buyer = new Buyer()
                .setId(1).setEmail("kelyan.bervin@gmail.com")
                .setFirstname("kelyan")
                .setLastname("bervin")
                .setCreditCard(creditCard);

        var payment = new Payment().setBuyer(buyer).setCheckout_id("1").setAmount(12.3);
        paymentDAO.savePayment(payment, PaymentStatus.DONE);

        paymentDAO.update(payment.setBuyer(buyer).setCheckout_id("1").setAmount(28.5), PaymentStatus.DONE);

        paymentDAO.delete("1");

    }
}
