package com.foorder.model.menu;

import lombok.Getter;
import lombok.Setter;

public class MenuItem {
    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private Double price;
    @Getter @Setter private Integer timeToMake;

    public MenuItem(){
    }

    public MenuItem(String id, String name, Double price, Integer timeToMake) {
        this.name = name;
        this.price = price;
        this.timeToMake = timeToMake;
        this.id = id;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", timeToMake=" + timeToMake +
                '}';
    }
}
