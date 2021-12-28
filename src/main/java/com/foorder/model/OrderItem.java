package com.foorder.model;

import lombok.Getter;

public class OrderItem {
    @Getter private final String itemId;
    @Getter private final String quantity;

    public OrderItem(String itemId, String quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }
}
