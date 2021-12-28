package com.foorder.model;

import lombok.Getter;

public class Delivery {
    @Getter private final String id;
    @Getter private final String orderId;
    @Getter private final String restaurantId;
    @Getter private final String username;

    public Delivery(String id, String orderId, String restaurantId, String username) {
        this.id = id;
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.username = username;
    }
}
