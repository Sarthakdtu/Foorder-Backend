package com.foorder.constants;


public enum EventType {

    ORDER_PLACED("ORDER_PLACED");

    public final String name;

    EventType(String name) {
        this.name = name;
    }
}
