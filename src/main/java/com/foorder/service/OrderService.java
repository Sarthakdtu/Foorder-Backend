package com.foorder.service;

import com.foorder.exceptions.MenuDoestNotExistException;
import com.foorder.model.*;

import java.util.HashMap;
import java.util.List;

public interface OrderService {

    Order getOrderById(String id);
    OrderWithName getOrderDetailsById(String id);
    void insertPendingOrder(PendingOrder order, List<OrderItem> items) throws Exception;
    void deletePendingOrder(String orderId);
    void insertDeliveredOrder(Order order);
    void deleteDeliveredOrder(String orderId);
    List<Order> getAllPendingOrdersByRestaurantId(String restaurantId);
    List<Order> getAllDeliveredOrdersByRestaurantId(String restaurantId);
    List<Order> getOrderHistoryByUser(String username);
    List<Order> getOrderHistoryByRestaurant(String restaurantId);
    String validateOrder(Order order, List<OrderItem> items, HashMap<String, Integer> idTtmMap) throws Exception;
    List<Order> getAllPendingOrderByRestaurantId(String restaurantId);
    List<Order> getAllPendingOrderByUsername(String username);
}
