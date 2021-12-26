package com.foorder.service.impl;

import com.foorder.dao.CityDao;
import com.foorder.model.City;
import com.foorder.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDao cityDao;

    @Override
    public City getCityByName(String name) {
        return cityDao.getCityByName(name);
    }

    @Override
    public void insertCity(City city) {
        cityDao.insertCity(city);
    }

    @Override
    public void deleteCity(String name) {
        cityDao.deleteCity(name);
    }

    @Override
    public List<City> getAllCities() {
        return cityDao.getAllCities();
    }
}
