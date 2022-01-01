package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class PendingOrder extends Order {

    @Getter @Setter
    private LocalDateTime pickupTime;  //expected to be picked up at - not the actual pickup time

    public PendingOrder(String id,
                          String username,
                          String restaurantId,
                          LocalDateTime orderTime,
                          String orderedItemsId,
                          String price, LocalDateTime pickupTime) {
        super(id, username, restaurantId, orderTime, orderedItemsId, price);
        this.pickupTime = pickupTime;
    }

    public PendingOrder(Order order, LocalDateTime pickupTime) {
        super(order);
        this.pickupTime = pickupTime;
    }

    public PendingOrder(String id, String username, String restaurantId) {
        super(id, username, restaurantId);
    }
}
