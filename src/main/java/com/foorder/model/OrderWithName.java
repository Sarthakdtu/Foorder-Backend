package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class OrderWithName extends Order{

    @Getter @Setter
    private String restaurantName;

    @Getter @Setter
    private List<OrderItemWithName> orderItemWithNameList;


    public OrderWithName(String id, String username, String restaurantId) {
        super(id, username, restaurantId);
    }

    public OrderWithName(String id, String username, String restaurantId, LocalDateTime orderTime, Double price) {
        super(id, username, restaurantId, orderTime, price);
    }

    public OrderWithName(Order order, String restaurantName, List<OrderItemWithName> orderItemWithNameList) {
        super(order);
        this.restaurantName = restaurantName;
        this.orderItemWithNameList = orderItemWithNameList;
    }
}
