package com.foorder.events;

import com.foorder.kafkaUtils.KafkaClient;
import org.json.JSONException;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedEvent {

    public void produce(String msg) throws JSONException {
        KafkaClient kafkaClient = KafkaClient.getInstance();
        kafkaClient.produce(msg);
    }
}
