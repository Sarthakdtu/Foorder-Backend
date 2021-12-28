package com.foorder.controller.v1.api;

import com.foorder.model.Menu;
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

    @GetMapping("/get-menu")
    public Menu getMenuByRestaurantId(@RequestParam String restaurantId){
        Menu menu = null;
        try{
            menu = menuService.getMenuByRestaurantId(restaurantId);
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return menu;
    }

    @GetMapping("/get-menu-items")
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
    public boolean addMenuItems(@RequestBody HashMap<String, String> req) throws SQLException {
        boolean insert = false;
        try{
            String restaurantId = req.get("restaurantId");
//            List<MenuItem> items = req.get("items");
            System.out.println(req.get("items"));
            Menu menu = new Menu(restaurantId);
            menuService.insertMenu(menu);
            insert = true;
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
            e.printStackTrace();
        }
        return insert;
    }

    @PutMapping("/edit")
    public boolean editMenu(@RequestBody HashMap<String, String> req){
        String restaurantId = req.get("restaurantId");
        boolean edit = false;
        try{
            menuService.editMenu(restaurantId);
            edit = true;
        }
        catch (Exception e){
            LoggerService.error(e.getMessage());
        }
        return edit;
    }

}
