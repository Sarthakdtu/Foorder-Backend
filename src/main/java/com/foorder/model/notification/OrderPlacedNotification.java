package com.foorder.model.notification;

import com.foorder.model.order.OrderItemWithName;
import com.google.gson.Gson;
import lombok.Getter;

import java.util.List;

public class OrderPlacedNotification {

    @Getter private final String orderId;
    @Getter private final String username;
    @Getter private final String restaurantName;
    @Getter private final List<OrderItemWithName> orderItemWithNameList;


    public OrderPlacedNotification(String orderId, String username, String restaurantName, List<OrderItemWithName> orderItemWithNameList) {
        this.orderId = orderId;
        this.username = username;
        this.restaurantName = restaurantName;
        this.orderItemWithNameList = orderItemWithNameList;
    }

    public String toJson(){
        return new Gson().toJson(this);
    }
}
