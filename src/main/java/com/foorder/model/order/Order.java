package com.foorder.model.order;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public abstract class Order {

    @Getter protected final String id;
    @Getter protected final String username;
    @Getter protected final String restaurantId;
    @Getter @Setter protected LocalDateTime orderTime;
    @Getter @Setter protected Double price;

    public Order(String id, String username, String restaurantId) {
        this.id = id;
        this.username = username;
        this.restaurantId = restaurantId;
    }

    public Order(String id, String username, String restaurantId, LocalDateTime orderTime, Double price) {
        this.id = id;
        this.price = price;
        this.username = username;
        this.restaurantId = restaurantId;
        this.orderTime = orderTime;
    }

    public Order(Order order) {
        this.orderTime = order.getOrderTime();
        this.price = order.getPrice();
        this.id = order.getId();
        this.restaurantId = order.getRestaurantId();
        this.username = order.getUsername();
    }
}
