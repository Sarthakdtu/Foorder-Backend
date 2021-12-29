package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class DeliveredOrder extends Order {

    @Getter private final LocalDateTime deliverTime;
    @Getter @Setter private String deliveryId;
    public DeliveredOrder(String id,
                          String username,
                          String restaurantId,
                          LocalDateTime orderTime,
                          String orderedItemsId,
                          String price,
                          LocalDateTime deliverTime, String deliveryId) {
        super(id, username, restaurantId, orderTime, orderedItemsId, price);
        this.deliverTime = deliverTime;
        this.deliveryId = deliveryId;
    }

    public DeliveredOrder(PendingOrder order, LocalDateTime deliverTime, String deliveryId){
        super(order.getId(),
                order.getUsername(),
                order.getRestaurantId(),
                order.getOrderTime(),
                order.getOrderedItemsId(),
                order.getPrice());
        this.deliverTime = deliverTime;
        this.deliveryId = deliveryId;
    }
}
