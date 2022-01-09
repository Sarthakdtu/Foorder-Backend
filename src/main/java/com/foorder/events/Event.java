package com.foorder.events;

import com.foorder.constants.EventType;
import com.foorder.kafkaUtils.KafkaClient;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONException;

public abstract class Event {

    @Getter protected final EventType type;

    @Getter @Setter
    protected String message;
    public Event(EventType type) {
        this.type = type;
    }

    public String toJson(){
        return new Gson().toJson(this);
    }

    public void produce() throws JSONException {
        KafkaClient kafkaClient = KafkaClient.getInstance();
        kafkaClient.produce(this.toJson());
    }
}
