package com.example.paymentservice.domain;

import com.example.paymentservice.domain.entity.Payment;
import com.example.paymentservice.domain.entity.PaymentStatus;
import redis.clients.jedis.Jedis;

public class PaymentDaoRedisImpl implements PaymentDAO{

    private final Jedis jedis = new Jedis();

    @Override
    public void savePayment(Payment payment, PaymentStatus status) {
        jedis.set(payment.getCheckout_id(), status.name());
        jedis.expire(payment.getCheckout_id(), 21600);
    }

    @Override
    public boolean exist(String checkoutId) {
        var payment = jedis.keys(checkoutId);
        return !payment.isEmpty();
    }

    @Override
    public PaymentStatus getByCheckoutId(String checkoutId) {

        var status  = jedis.get(checkoutId);

        return PaymentStatus.valueOf(status.toUpperCase());
    }


    @Override
    public void update(Payment payment, PaymentStatus status) {
        jedis.set(payment.getCheckout_id(), status.name());
    }

    @Override
    public void delete(String id) {
        jedis.del(id);
    }
}
