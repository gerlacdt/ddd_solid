package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderUseCase implements ICreateOrderUseCase {

  private final EventHandler<OrderCreatedEvent> eventHandler;

  @Autowired
  public CreateOrderUseCase(
      @Qualifier("compositeOrderCreatedEventHandler")
          EventHandler<OrderCreatedEvent> eventHandler) {
    this.eventHandler = eventHandler;
  }

  @Override
  public Order createOrder(OrderParams params) {
    String id = "randomOrderId";
    Order order = new Order(id, params.getItemId(), params.getAmount());

    eventHandler.handle(new OrderCreatedEvent(order));

    return order;
  }
}
