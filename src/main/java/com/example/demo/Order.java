package com.example.demo;

import java.util.Objects;

public class Order {

    private final String id;
    private final String itemId;
    private final int amount;

    public Order(String id, String itemId, int amount) {
        if (null == id) {
            throw new IllegalArgumentException("id must not be null");
        }
        if (null == itemId) {
            throw new IllegalArgumentException("itemId must not be null");
        }

        this.itemId = itemId;
        this.amount = amount;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
