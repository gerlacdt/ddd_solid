package com.example.demo;

public class OrderParams {

  private final String itemId;

  public String getItemId() {
    return itemId;
  }

  public int getAmount() {
    return amount;
  }

  private final int amount;

  public OrderParams(String itemId, int amount) {
    this.itemId = itemId;
    this.amount = amount;
  }

  public String toString() {
    return String.format("[itemId: %s, amount: %d]", this.itemId, this.amount);
  }
}
