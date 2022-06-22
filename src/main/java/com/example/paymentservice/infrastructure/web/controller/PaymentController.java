package com.example.paymentservice.infrastructure.web.controller;

import com.example.paymentservice.domain.PaymentDaoRedisImpl;
import com.example.paymentservice.domain.mapper.PaymentMapper;
import com.example.paymentservice.domain.service.PaymentService;
import com.example.paymentservice.domain.service.PaymentValidationService;
import com.example.paymentservice.domain.entity.PaymentStatus;
import com.example.paymentservice.infrastructure.web.request.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.util.annotation.NonNull;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentValidationService paymentValidationService;
    private final PaymentService paymentService;
    private final PaymentDaoRedisImpl paymentDao;

    private final PaymentMapper paymentMapper;

    public PaymentController(PaymentValidationService paymentValidationService, PaymentService paymentService, PaymentDaoRedisImpl paymentDao, PaymentMapper paymentMapper) {
        this.paymentValidationService = paymentValidationService;
        this.paymentService = paymentService;
        this.paymentDao = paymentDao;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping()
    public ResponseEntity<?> payment(@RequestBody @NonNull PaymentRequest paymentRequest){
        var payment = paymentMapper.toEntity(paymentRequest);
        if(!paymentDao.exist(payment.getCheckout_id()) || paymentDao.getByCheckoutId(payment.getCheckout_id()) == PaymentStatus.REFUSED){
            paymentDao.savePayment(payment, PaymentStatus.NONE);

            if(!paymentValidationService.isValid(paymentRequest)){
                paymentDao.update(payment, PaymentStatus.REFUSED);
                return new ResponseEntity<>("Paiement Refusé", HttpStatus.BAD_REQUEST);
            }
            paymentService.payment(paymentRequest.getCheckout_id());
            paymentDao.update(payment, PaymentStatus.DONE);
            return new ResponseEntity<>("Paiement accepté", HttpStatus.ACCEPTED);
        }
        //payment done || payment in progress
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
