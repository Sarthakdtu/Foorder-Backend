package com.foorder.model.order;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class PendingOrder extends Order {

    @Getter @Setter private LocalDateTime pickUpTime;  //expected to be picked up at - not the actual pickup time

    public PendingOrder(  String id,
                          String username,
                          String restaurantId,
                          LocalDateTime orderTime,
                          Double price,
                          LocalDateTime pickUpTime) {
        super(id, username, restaurantId, orderTime, price);
        this.pickUpTime = pickUpTime;
    }

    public PendingOrder(Order order, LocalDateTime pickUpTime) {
        super(order);
        this.pickUpTime = pickUpTime;
    }

    public PendingOrder(String id, String username, String restaurantId) {
        super(id, username, restaurantId);
    }

    @Override
    public String toString() {
        return "PendingOrder{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", orderTime=" + orderTime +
                ", price='" + price + '\'' +
                ", pickUpTime=" + pickUpTime +
                '}';
    }

    public String toJson(){
        return new Gson().toJson(this);
    }
}
