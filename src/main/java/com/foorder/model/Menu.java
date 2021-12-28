package com.foorder.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("menu")
public class Menu {

    @Id
    @Getter private String id;
    @Getter private String restaurantId;
    @Getter @Setter private List<MenuItem> items;

    @PersistenceConstructor
    public Menu(String restaurantId){
        this.restaurantId = restaurantId;
    }

    public Menu(String restaurantId, List<MenuItem> items) {
        this.restaurantId = restaurantId;
        this.items = null;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "restaurantId='" + restaurantId + '\'' +
                ", items=" + items +
                '}';
    }
}
