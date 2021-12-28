package com.foorder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class City {

    @JsonProperty("name")
    @Getter private final String name;

    public City(String name) {
        this.name = name;
    }
}
