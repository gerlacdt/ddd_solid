package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ConfirmEmailHandler implements EventHandler<OrderCreatedEvent> {
    @Override
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        System.out.println("sent confirmation email to customer");
    }
}
