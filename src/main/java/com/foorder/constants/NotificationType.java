package com.foorder.constants;

public enum NotificationType {

    ORDER_PLACED("ORDER_PLACED");

    public final String name;

    private NotificationType(String name) {
        this.name = name;
    }
}
