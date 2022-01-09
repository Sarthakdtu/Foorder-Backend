package com.foorder.model.notification;

import com.foorder.constants.NotificationType;
import lombok.Getter;

public abstract class Notification {

    @Getter
    protected final NotificationType type;

    protected Notification(NotificationType type) {
        this.type = type;
    }
}
