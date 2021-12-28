package com.foorder.controller.v1.api;

import com.foorder.model.MenuItem;
import com.foorder.service.MenuService;
import com.foorder.utils.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping("")
    public Object getHealth(){
        HashMap<String, Boolean> result = new HashMap<>();
        result.put("alive", true);
        return result;
    }


    @GetMapping("/get")
    public List<MenuItem> getMenuItems(@RequestParam String restaurantId){
        List<MenuItem> items = null;
        try{
            items = menuService.getMenuItems(restaurantId);
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return items;
    }

    @PostMapping("/add-items")
    public boolean addMenuItems(@RequestBody HashMap<String, Object> req) throws SQLException {
        boolean insert = false;
        try{
            String restaurantId = (String) req.get("restaurantId");
            List<MenuItem> items = (List<MenuItem>) req.get("items");
            menuService.addItems(restaurantId, items);
            insert = true;
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
            e.printStackTrace();
        }
        return insert;
    }
}
