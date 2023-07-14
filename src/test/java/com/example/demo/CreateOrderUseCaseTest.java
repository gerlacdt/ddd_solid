package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateOrderUseCaseTest {

  @Autowired
  @Qualifier("decoratedCreateOrderUseCase")
  private ICreateOrderUseCase sut;

  @Test
  public void createOrderTest_validInput_ok() {
    String id = "id";
    Order actual = sut.createOrder(new OrderParams("itemId", 2));
    assertTrue(actual.getId() != null);
    assertEquals("itemId", actual.getItemId());
    assertEquals(2, actual.getAmount());
  }
}
