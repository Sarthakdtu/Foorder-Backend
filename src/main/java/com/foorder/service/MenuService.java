package com.foorder.service;

import com.foorder.model.Menu;
import com.foorder.model.MenuItem;

import java.util.List;

public interface MenuService {
    public Menu getMenuByRestaurantId(String restaurantId);
    public String insertMenu(Menu menu);
    public void deleteMenu(String id);
    public void updateMenu(List<MenuItem> items);
    public List<MenuItem> getMenuItems(String id);
}
