package com.foorder.controller.v1.api;

import com.foorder.model.City;
import com.foorder.service.CityService;
import com.foorder.utils.LoggerService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("")
    public Object getHealth(){
        HashMap<String, Boolean> result = new HashMap<>();
        result.put("alive", true);
        return result;
    }

    @GetMapping("/get")
    public City getCityByName(@RequestParam String name) throws SQLException, JSONException {
        City city = null;
        try{
            city = cityService.getCityByName(name);
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return city;
    }

    @GetMapping("/get-all")
    public List<City> getTopNUserProfiles() throws SQLException, JSONException {
        List<City> cities = null;
        try{
            cities = cityService.getAllCities();
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return cities;
    }

    @PostMapping("/create")
    public boolean createCity(@RequestBody HashMap<String, String> req) throws SQLException {
        boolean insert = false;
        try{
            String name = req.get("name");
            City city = new City(name);
            cityService.insertCity(city);
            insert = true;
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
            e.printStackTrace();
        }
        return insert;
    }

    @DeleteMapping("/delete")
    public boolean deleteCity(@RequestBody HashMap<String, String> req){
        String name = req.get("name");
        boolean delete = false;
        try{
            cityService.deleteCity(name);
            delete = true;
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return delete;
    }
}
