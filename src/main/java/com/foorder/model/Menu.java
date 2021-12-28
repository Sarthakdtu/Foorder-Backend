package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Menu {
    @Getter private final String restaurantId;
    @Getter @Setter private List<MenuItem> items;

    public Menu(String restaurantId) {
        this.restaurantId = restaurantId;
        this.items = null;
    }
}
