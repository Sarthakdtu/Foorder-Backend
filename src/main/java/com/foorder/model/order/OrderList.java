package com.foorder.model.order;

import com.foorder.model.order.OrderItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("order_list")
public class OrderList {

    @Id
    private final String orderId;

    @Getter @Setter
    private List<OrderItem> items;

    @PersistenceConstructor
    public OrderList(String orderId) {
        this.orderId = orderId;
    }

    @PersistenceConstructor
    public OrderList(String orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "orderId='" + orderId + '\'' +
                ", items=" + items +
                '}';
    }
}
