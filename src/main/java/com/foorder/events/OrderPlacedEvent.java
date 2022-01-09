package com.foorder.events;

import com.foorder.constants.EventType;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedEvent extends Event{

    protected OrderPlacedEvent() {
        super(EventType.ORDER_PLACED);
    }
}
