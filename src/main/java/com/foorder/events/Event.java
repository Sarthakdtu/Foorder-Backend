package com.foorder.events;

import com.foorder.constants.EventType;
import com.foorder.kafkaUtils.KafkaClient;
import lombok.Getter;
import org.json.JSONException;

public abstract class Event {

    @Getter protected final EventType type;

    public Event(EventType type) {
        this.type = type;
    }

    public void produce(String msg) throws JSONException {
        KafkaClient kafkaClient = KafkaClient.getInstance();
        kafkaClient.produce(msg);
    }
}
