package com.foorder.model;

import lombok.Getter;

import java.time.LocalDateTime;

public class PendingOrder extends Order {

    public PendingOrder(String id,
                          String username,
                          String restaurantId,
                          LocalDateTime orderTime,
                          String orderedItemsId,
                          String price) {
        super(id, username, restaurantId, orderTime, orderedItemsId, price);
    }
}
