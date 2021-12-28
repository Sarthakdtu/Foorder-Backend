package com.foorder.dao.postgres.impl;

import com.foorder.dao.postgres.RestaurantDao;
import com.foorder.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {
    @Override
    public Restaurant getRestaurantById(String id) {
        return null;
    }

    @Override
    public void insertRestaurant(Restaurant restaurant) {

    }

    @Override
    public void deleteRestaurant(String id) {

    }

    @Override
    public List<Restaurant> getAllRestaurantsByCity(String cityName) {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurantsByStreet(String streetName, String cityName) {
        return null;
    }
}
