package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderUseCase implements ICreateOrderUseCase {

    private final EventHandler<OrderCreatedEvent> eventHandler;

    @Autowired
    public CreateOrderUseCase(@Qualifier("compositeCreatedOrderEventHandler") EventHandler<OrderCreatedEvent> eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public Order createOrder(OrderParams params) {
        String id = "randomOrderId";
        return new Order(id, params.getItemId(), params.getAmount());

    }
}
