package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

public class Restaurant {

    @Getter private final String id;
    @Getter private final String name;
    @Getter private final String streetName;
    @Getter private final String cityName;

    public Restaurant(String id, String name, String streetName, String cityName) {
        this.id = id;
        this.name = name;
        this.streetName = streetName;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", streetName='" + streetName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
