package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public abstract class Order {

    @Getter protected final String id;
    @Getter protected final String username;
    @Getter protected final String restaurantName;
    @Getter protected final LocalDateTime orderTime;
    @Getter protected final String orderedItemsId;
    @Getter @Setter protected String price;

    public Order(String id, String username, String restaurantName, LocalDateTime orderTime, String orderedItemsId, String price) {
        this.id = id;
        this.price = price;
        this.username = username;
        this.restaurantName = restaurantName;
        this.orderTime = orderTime;
        this.orderedItemsId = orderedItemsId;
    }
}
