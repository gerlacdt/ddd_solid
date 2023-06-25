package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService sut;

    @Test
    public void getOrderTest() {
        String id = "id";
        Order actual = sut.getOrder(id);

        Order expected = new Order(id);
        assertEquals(expected, actual);

    }
}
