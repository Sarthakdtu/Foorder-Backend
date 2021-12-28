package com.foorder.model;

import lombok.Getter;

import java.time.LocalDateTime;

public class PendingOrder extends Order {

    public PendingOrder(String id,
                          String username,
                          String restaurantName,
                          LocalDateTime orderTime,
                          String orderedItemsId,
                          String price) {
        super(id, username, restaurantName, orderTime, orderedItemsId, price);
    }
}
