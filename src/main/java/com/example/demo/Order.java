package com.example.demo;

import java.util.Objects;

public class Order {

    private String id;

    public Order(String id) {
        if (null == id) {
            throw new IllegalArgumentException("OrderID must not be null");
        }

        this.id = id;
    }

    public String getId() {
        return id;
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
