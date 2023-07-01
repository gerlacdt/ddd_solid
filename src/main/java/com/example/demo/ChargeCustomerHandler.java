package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChargeCustomerHandler implements EventHandler<OrderCreatedEvent> {
    private final PaymentGateway paymentGateway;

    @Autowired
    public ChargeCustomerHandler(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        this.paymentGateway.chargeCustomer((orderCreatedEvent.getOrder()));
    }
}
