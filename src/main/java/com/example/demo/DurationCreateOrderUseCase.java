package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DurationCreateOrderUseCase implements ICreateOrderUseCase {

  private static Logger log = LoggerFactory.getLogger(DurationCreateOrderUseCase.class);

  private ICreateOrderUseCase inner;

  public DurationCreateOrderUseCase(ICreateOrderUseCase inner) {
    this.inner = inner;
  }

  @Override
  public Order createOrder(OrderParams params) {
    var start = System.nanoTime();

    // execute logic
    var order = this.inner.createOrder(params);

    var end = System.nanoTime();
    var durationMicros = (end - start) / 1000;
    log.info("[DURATION] createOrder() => {} micro seconds", durationMicros);

    return order;
  }
}
