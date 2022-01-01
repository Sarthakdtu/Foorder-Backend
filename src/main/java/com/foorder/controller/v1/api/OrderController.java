package com.foorder.controller.v1.api;

import com.foorder.exceptions.OrderItemInvalidException;
import com.foorder.model.*;
import com.foorder.model.Order;
import com.foorder.service.OrderService;
import com.foorder.utils.LoggerService;
import com.foorder.utils.RandomStrings;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("")
    public Object getHealth(){
        HashMap<String, Boolean> result = new HashMap<>();
        result.put("alive", true);
        return result;
    }

    @GetMapping("/get")
    public Order getOrderById(@RequestParam String id) throws SQLException, JSONException {
        Order order = null;
        try{
            order = orderService.getOrderById(id);
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return order;
    }

    @GetMapping("/restaurant")
    public List<Order> getAllPendingOrderByRestaurantId(@RequestParam String restaurantId) throws SQLException, JSONException {
        List<Order> orders = null;
        try{
            orders = orderService.getAllPendingOrderByRestaurantId(restaurantId);
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return orders;
    }

    @GetMapping("/user")
    public List<Order> getAllPendingOrderByUsername(@RequestParam String username) throws SQLException, JSONException {
        List<Order> orders = null;
        try{
            orders = orderService.getAllPendingOrderByUsername(username);
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return orders;
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody HashMap<String, Object> req) throws Exception {

        String id = RandomStrings.generateOrderId();
        try{
            String username = (String) req.get("username");
            String restaurantId = (String) req.get("restaurantId");
            List<HashMap<String, Object>> itemList = (List<HashMap<String, Object>>) req.get("items");
            List<OrderItem> orderItems = new ArrayList<>();
            HashMap<String, Integer> coveredItems = new HashMap<>();
            for (HashMap<String, Object> item : itemList) {
                if(item.isEmpty() || !item.containsKey("id") || !item.containsKey("quantity")){
                    throw new OrderItemInvalidException();
                }
                String itemId = (String) item.get("id");
                Integer quantity = (Integer) item.get("quantity");
                Integer oldQty = coveredItems.getOrDefault(itemId, 0);
                if(oldQty == 0){
                    coveredItems.put(itemId, quantity);
                }
                else{
                    coveredItems.put(itemId, oldQty + quantity);
                }
            }

            for (Map.Entry<String, Integer> entry : coveredItems.entrySet()) {
                OrderItem tempItem = new OrderItem(entry.getKey(), entry.getValue());
                orderItems.add(tempItem);
            }

            PendingOrder order = new PendingOrder(id, username, restaurantId);
            orderService.insertPendingOrder(order, orderItems);
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
            e.printStackTrace();
        }
        return id;
    }

    @DeleteMapping("/cancel")
    public boolean cancelOrder(@RequestBody HashMap<String, String> req){
        String id = req.get("id");
        boolean delete = false;
        try{
            orderService.deletePendingOrder(id);
            delete = true;
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return delete;
    }
}
