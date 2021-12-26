package com.foorder.model;

public class UserProfile {
    private final String username;

    private String houseNumber;

    private String cityId;

    private String streetId;

    public UserProfile(String username){
        this.username = username;
    }

    public UserProfile(String username, String houseNumber, String cityId, String streetId) {
        this.username = username;
        this.houseNumber = houseNumber;
        this.cityId = cityId;
        this.streetId = streetId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    public String getCityId() {
        return cityId;
    }

    public String getStreetId() {
        return streetId;
    }

    public String getUsername() {
        return username;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
}
