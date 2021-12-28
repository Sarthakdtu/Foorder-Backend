package com.foorder.dao.postgres;

import com.foorder.model.City;

import java.util.List;

public interface CityDao {
    public City getCityByName(String name);
    public void insertCity(City city);
    public void deleteCity(String name);
    public List<City> getAllCities();
}
