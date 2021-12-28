package com.foorder.dao;

import com.foorder.model.Street;

import java.util.List;

public interface StreetDao {
    public Street getStreetById(String name, String cityName);
    public List<Street> getStreetsByPincode(Long pincode);
    public void insertStreet(Street street);
    public void deleteStreet(String name, String cityName);
    public List<Street> getAllStreetsCity(String cityName);
}
