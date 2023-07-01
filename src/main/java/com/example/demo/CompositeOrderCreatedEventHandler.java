package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("compositeOrderCreatedEventHandler")
public class CompositeOrderCreatedEventHandler implements EventHandler<OrderCreatedEvent> {

    private final List<EventHandler<OrderCreatedEvent>> eventHandlers;

    @Autowired
    public CompositeOrderCreatedEventHandler(List<EventHandler<OrderCreatedEvent>> eventHandlers) {
        this.eventHandlers = eventHandlers;
    }

    @Override
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        // call all registered event handler for OrderCreatedEvent
        for (EventHandler<OrderCreatedEvent> handler : this.eventHandlers) {
            handler.handle(orderCreatedEvent);
        }
    }
}
