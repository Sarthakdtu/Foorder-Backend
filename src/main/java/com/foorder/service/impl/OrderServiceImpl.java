package com.foorder.service.impl;

import com.foorder.dao.postgres.DeliveredOrderDao;
import com.foorder.dao.postgres.PendingOrderDao;
import com.foorder.exceptions.*;
import com.foorder.model.*;
import com.foorder.service.MenuService;
import com.foorder.service.OrderService;
import com.foorder.service.RestaurantService;
import com.foorder.service.UserProfileService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    PendingOrderDao pendingOrderDao;

    @Autowired
    DeliveredOrderDao deliveredOrderDao;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    MenuService menuService;

    private void validateCity(String userCity, String restaurantCity) throws DifferentCityException {
        if(!userCity.equals(restaurantCity)){
            throw new DifferentCityException();
        }
    }

    private void validateNumberUniqueItems(List<OrderItem> items) throws UniqueOrderItemQtyExceeded {
        if(items.size() > 10){
            throw new UniqueOrderItemQtyExceeded();
        }
    }

    private void validateItemExistence(List<OrderItem> items, String restaurantId, HashMap<String, Integer> idTtmMap) throws OrderItemDoesNotExistException {
        for (OrderItem item: items) {
            if(idTtmMap.getOrDefault(item.getId(), 0) == 0){
                throw new OrderItemDoesNotExistException();
            }
        }
    }

    private void validateItemQuantity(List<OrderItem> items) throws OrderItemQtyExceeded {
        for (OrderItem item: items) {
            if(item.getQuantity() > 10){
                throw new OrderItemQtyExceeded();
            }
        }
    }

    @Override
    public String validateOrder(Order order, List<OrderItem> items, HashMap<String, Integer> idTtmMap) throws Exception {
        UserProfile userProfile = userProfileService.getUserProfileById(order.getUsername());
        Restaurant restaurant = restaurantService.getRestaurantById(order.getRestaurantId());
        validateCity(userProfile.getCityName(), restaurant.getCityName());
        validateNumberUniqueItems(items);
        validateItemExistence(items, order.getRestaurantId(), idTtmMap);
        validateItemQuantity(items);
        return restaurant.getCityName();
    }


    @Override
    public Order getOrderById(String id) {
        return null;
    }

    private HashMap<String, Integer> getMenuItemIdTtmMap(List<MenuItem> menuItems) throws MenuDoestNotExistException {
        if(menuItems == null){
            throw new MenuDoestNotExistException();
        }
        HashMap<String, Integer> idTtmMap = new HashMap<>();
        for (MenuItem item: menuItems) {
            idTtmMap.put(item.getId(), item.getTimeToMake());
        }
        return idTtmMap;
    }


    private LocalDateTime getTimeToPrepare(LocalDateTime currentTime, HashMap<String, Integer> idTtmMap){
        Integer timeToPrepare = 0;
        for(Map.Entry<String, Integer> entry : idTtmMap.entrySet()){
            timeToPrepare += entry.getValue();
        }
        return currentTime.plusSeconds(timeToPrepare);
    }

    @Override
    public void insertPendingOrder(PendingOrder order, List<OrderItem> items) throws Exception {
        List<MenuItem> menuItems = menuService.getMenuItems(order.getRestaurantId());
        HashMap<String, Integer> idTtmMap = this.getMenuItemIdTtmMap(menuItems);
        String cityName = this.validateOrder(order, items, idTtmMap);
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime pickUpTime = this.getTimeToPrepare(currentTime, idTtmMap);
        order.setOrderTime(currentTime);
        order.setPickupTime(pickUpTime);




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


    @Override
    public List<Order> getAllPendingOrderByRestaurantId(String restaurantId) {
        return null;
    }

    @Override
    public List<Order> getAllPendingOrderByUsername(String username) {
        return null;
    }
}
