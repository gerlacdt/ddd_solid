package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@TestConfiguration
public class FakeConfig {

    @Bean
    @Qualifier("compositeOrderCreatedEventHandler")
    public EventHandler<OrderCreatedEvent> eventHandler(PaymentGateway paymentGateway) {
        var warehouseHandler = new NotifyWarehouseHandler();
        var chargeCustomerHandler = new ChargeCustomerHandler(paymentGateway);
        List<EventHandler<OrderCreatedEvent>> handlers = List.of(warehouseHandler, chargeCustomerHandler);
        var compositeHandler = new CompositeOrderCreatedEventHandler(handlers);
        return compositeHandler;
    }
}
