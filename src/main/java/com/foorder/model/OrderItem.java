package com.foorder.model;

import lombok.Getter;

public class OrderItem {
    @Getter private final String id;
    @Getter private final Integer quantity;

    public OrderItem(String id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
