package com.example.demo;

public interface EventHandler<TEvent> {

    void handle(TEvent event);
}
