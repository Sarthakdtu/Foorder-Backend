package com.foorder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {

    @JsonProperty("name")
    private final String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
