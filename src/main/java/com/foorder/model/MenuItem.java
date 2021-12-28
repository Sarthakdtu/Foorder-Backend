package com.foorder.model;

import lombok.Getter;
import lombok.Setter;

public class MenuItem {
    @Getter @Setter private String name;
    @Getter @Setter private Double price;
    @Getter @Setter private Integer timeToMake;
}
