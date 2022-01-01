package com.foorder.dao.postgres;

import com.foorder.model.Order;

import java.util.List;

public interface PendingOrderDao {
    Order getOrderById(String id);
    void insertPendingOrder(Order order);
    void deletePendingOrder(String orderId);
    void insertDeliveredOrder(Order order);
    void deleteDeliveredOrder(String orderId);
    List<Order> getAllPendingOrdersByRestaurantId(String restaurantId);
    List<Order> getAllDeliveredOrdersByRestaurantId(String restaurantId);
    List<Order> getOrderHistoryByUser(String username);
    List<Order> getOrderHistoryByRestaurant(String restaurantId);
    boolean validateOrder(Order order);



    List<Order> getAllPendingOrderByRestaurantId(String restaurantId);

    List<Order> getAllPendingOrderByUsername(String username);
}
