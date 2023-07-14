package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class NotifyWarehouseHandler implements EventHandler<OrderCreatedEvent> {
  @Override
  public void handle(OrderCreatedEvent orderCreatedEvent) {
    System.out.println("[EVENT] notify warehouse of new order");
  }
}
