package com.foorder.model;

public class Street {
    private final String name;
    private final String cityName;
    private final Long pincode;

    public Street(String name, String cityName, Long pincode) {
        this.name = name;
        this.cityName = cityName;
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }
    public String getCityName() { return cityName; }
    public Long getPincode() { return pincode; }
}
