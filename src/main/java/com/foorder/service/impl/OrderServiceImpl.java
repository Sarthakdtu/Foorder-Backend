package com.foorder.service.impl;

import com.foorder.model.Order;
import com.foorder.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order getOrderById(String id) {
        return null;
    }

    @Override
    public void insertPendingOrder(Order order) {

    }

    @Override
    public void deletePendingOrder(String orderId) {

    }

    @Override
    public void insertDeliveredOrder(Order order) {

    }

    @Override
    public void deleteDeliveredOrder(String orderId) {

    }

    @Override
    public List<Order> getAllPendingOrdersByRestaurantId(String restaurantId) {
        return null;
    }

    @Override
    public List<Order> getAllDeliveredOrdersByRestaurantId(String restaurantId) {
        return null;
    }

    @Override
    public List<Order> getOrderHistoryByUser(String username) {
        return null;
    }

    @Override
    public List<Order> getOrderHistoryByRestaurant(String restaurantId) {
        return null;
    }
}
