package com.foorder.service;

import com.foorder.model.location.City;

import java.util.List;

public interface CityService {

    public City getCityByName(String name);
    public void insertCity(City city);
    public void deleteCity(String name);
    public List<City> getAllCities();
}
