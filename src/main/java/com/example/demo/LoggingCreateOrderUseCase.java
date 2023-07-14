package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCreateOrderUseCase implements ICreateOrderUseCase {

  private static Logger log = LoggerFactory.getLogger(LoggingCreateOrderUseCase.class);

  private ICreateOrderUseCase inner;

  public LoggingCreateOrderUseCase(ICreateOrderUseCase inner) {
    this.inner = inner;
  }

  @Override
  public Order createOrder(OrderParams params) {
    // log params
    log.info("[LoggingDecorator] function params: {}", params);
    return inner.createOrder(params);
  }
}
