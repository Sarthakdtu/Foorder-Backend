package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

public class OrderItemWithName extends OrderItem{

    @Getter @Setter private String name;

    public OrderItemWithName(String id, Integer quantity) {
        super(id, quantity);
    }

    public OrderItemWithName(OrderItem orderItem, String name){
        super(orderItem);
        this.name = name;
    }
}
