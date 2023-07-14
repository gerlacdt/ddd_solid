package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PaypalPaymentGateway implements PaymentGateway {
  @Override
  public void chargeCustomer(Order order) {
    System.out.println("[EVENT] Sent http call to payment provider and charge customer");
  }
}
