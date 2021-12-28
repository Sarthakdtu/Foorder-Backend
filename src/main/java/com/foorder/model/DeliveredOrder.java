package com.foorder.model;

import lombok.Getter;
import java.time.LocalDateTime;

public class DeliveredOrder extends Order {

    @Getter private final LocalDateTime deliverTime;
    @Getter private final String deliveryId;
    public DeliveredOrder(String id,
                          String username,
                          String restaurantName,
                          LocalDateTime orderTime,
                          String orderedItemsId,
                          String price,
                          LocalDateTime deliverTime, String deliveryId) {
        super(id, username, restaurantName, orderTime, orderedItemsId, price);
        this.deliverTime = deliverTime;
        this.deliveryId = deliveryId;
    }

    public DeliveredOrder(PendingOrder order, LocalDateTime deliverTime, String deliveryId){
        super(order.getId(),
                order.getUsername(),
                order.getRestaurantName(),
                order.getOrderTime(),
                order.getOrderedItemsId(),
                order.getPrice());
        this.deliverTime = deliverTime;
        this.deliveryId = deliveryId;
    }
}
