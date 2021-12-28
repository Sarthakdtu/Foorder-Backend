package com.foorder.model;

import lombok.Getter;

public class Street {
    @Getter private final String name;
    @Getter private final String cityName;
    @Getter private final Long pincode;

    public Street(String name, String cityName, Long pincode) {
        this.name = name;
        this.cityName = cityName;
        this.pincode = pincode;
    }
}
