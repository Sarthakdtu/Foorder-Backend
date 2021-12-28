package com.foorder.service.impl;

import com.foorder.model.MenuItem;
import com.foorder.model.Restaurant;
import com.foorder.service.MenuService;
import com.foorder.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    MenuService menuService;

    @Override
    public Restaurant getRestaurantById(String id) {
        return null;
    }

    @Override
    public void insertRestaurant(Restaurant restaurant) {}

    @Override
    public void deleteRestaurant(String id) {}

    @Override
    public List<Restaurant> getAllRestaurantsByCity(String cityName) {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurantsByStreet(String streetName, String cityName) {
        return null;
    }
}
