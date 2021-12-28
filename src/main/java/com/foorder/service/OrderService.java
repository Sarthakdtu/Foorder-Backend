package com.foorder.service;

import com.foorder.model.Order;

import java.util.List;

public interface OrderService {
    public Order getOrderById(String id);
    public void insertPendingOrder(Order order);
    public void deletePendingOrder(String orderId);
    public void insertDeliveredOrder(Order order);
    public void deleteDeliveredOrder(String orderId);
    public List<Order> getAllPendingOrdersByRestaurantId(String restaurantId);
    public List<Order> getAllDeliveredOrdersByRestaurantId(String restaurantId);
    public List<Order> getOrderHistoryByUser(String username);
    public List<Order> getOrderHistoryByRestaurant(String restaurantId);
}
