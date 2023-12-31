package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  public Order getOrder(String id) {
    return new Order(id, "itemId", 100);
  }

  public List<Order> getOrdersByUser(String userId) {
    return new ArrayList<>();
  }

  public Order createOrder(OrderParams params) {
    String id = "randomOrderId";
    return new Order(id, params.getItemId(), params.getAmount());
  }

  public void updateOrder(Order order) {}

  public void addToCard(String orderId) {}

  public void addDiscount(String orderId) {}

  public void addDiscountForPremiumCustomers(String orderId) {}

  public void shipOrder(String orderId) {}

  public OrderStatus getOrderStatus(String orderId) {

    return new OrderStatus();
  }

  public void cancelOrder(String orderId) {}
}
