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

        var creditCard = new CreditCard("1234567890", "123", "Kélyan");
        var buyer = new Buyer(1,  "kbervin@myges.fr", "Kélyan", "BERVIN", creditCard);


        paymentDAO.savePayment(new Payment(buyer, "1", 12.3), PaymentStatus.DONE);

        paymentDAO.update(new Payment(buyer, "1", 28.5), PaymentStatus.DONE);

        paymentDAO.delete("1");

    }
}
