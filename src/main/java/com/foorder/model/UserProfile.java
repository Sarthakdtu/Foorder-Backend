package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

public class UserProfile {
    @Getter private final String username;

    @Getter @Setter private String houseNumber;

    @Getter @Setter private String cityName;

    @Getter @Setter private String streetName;

    public UserProfile(String username){
        this.username = username;
    }

    public UserProfile(String username, String houseNumber, String cityName, String streetName) {
        this.username = username;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
        this.streetName = streetName;
    }
}
