package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

public class UserProfile {
    @Getter private final String username;

    @Getter @Setter private String houseNumber;

    @Getter @Setter private String cityId;

    @Getter @Setter private String streetId;

    public UserProfile(String username){
        this.username = username;
    }

    public UserProfile(String username, String houseNumber, String cityId, String streetId) {
        this.username = username;
        this.houseNumber = houseNumber;
        this.cityId = cityId;
        this.streetId = streetId;
    }
}
