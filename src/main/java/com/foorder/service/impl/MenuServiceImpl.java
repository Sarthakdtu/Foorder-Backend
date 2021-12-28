package com.foorder.service.impl;

import com.foorder.model.Menu;
import com.foorder.model.MenuItem;
import com.foorder.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Override
    public Menu getMenuByRestaurantId(String restaurantId) {
        return null;
    }

    @Override
    public String insertMenu(Menu menu) {
        return null;
    }

    @Override
    public void deleteMenu(String id) {

    }

    @Override
    public void updateMenu(List<MenuItem> items) {

    }

    @Override
    public List<MenuItem> getMenuItems(String id) {
        return null;
    }
}
