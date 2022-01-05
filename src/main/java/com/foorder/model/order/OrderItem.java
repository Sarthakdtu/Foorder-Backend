package com.foorder.model.order;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

public class OrderItem {

    @Id
    @Getter private final String id;
    @Getter private final Integer quantity;

    @PersistenceConstructor
    public OrderItem(String id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public OrderItem(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.quantity = orderItem.getQuantity();
    }
}
