package com.foorder.model.menu;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("menu")
public class Menu {

    @Id
    @Getter private final String rId; //restaurantId
    @Getter @Setter private List<MenuItem> items;

    @PersistenceConstructor
    public Menu(String rId){
        this.rId = rId;
    }

    public Menu(String restaurantId, List<MenuItem> items) {
        this.rId = restaurantId;
        this.items = null;
    }

    private String printMenuItems(){
        StringBuilder sb = new StringBuilder();
        for (MenuItem item:this.items) {
            sb.append(item.toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Menu{" +
                "restaurantId='" + rId + '\'' +
                ", items=" + items +
                '}';
    }
}
