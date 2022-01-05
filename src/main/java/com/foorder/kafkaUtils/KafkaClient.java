package com.foorder.kafkaUtils;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Properties;

public class KafkaClient implements Serializable {

    private KafkaConfig kafkaConfig;

    Logger logger = LoggerFactory.getLogger(KafkaClient.class.getName());

    private Properties kafkaProperties;

    private KafkaProducer<String, String> kafkaProducer;

    private static volatile KafkaClient soleInstance;

    public KafkaClient(){
        if (soleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        this.kafkaConfig = KafkaConfig.getInstance();
        this.setProperties();
        this.initProducer();
    }

    public void produce(String msg) throws JSONException {
//        String key = extractKey(msg);
        String key = "order";
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(kafkaConfig.getTopic(), key, msg);
        this.kafkaProducer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                //executes everytime a record is sent or an exception is thrown
                if (e == null) {
                    //record successfully sent
                    logger.info(recordMetadata.timestamp() +" Topic: " + recordMetadata.topic()  +
                            " Partition: " + recordMetadata.partition() +
                            " Offset: " + recordMetadata.offset());
                } else {
                    logger.error("ERROR: ", e);
                }
            }
        });
    }


    private String extractKey(String msg) throws JSONException {
        String key;
        JSONObject object = new JSONObject(msg);
        key = object.getString("customer_id");
        return key;
    }

    private void initProducer(){
        //create kafka producer
        this.kafkaProducer = new KafkaProducer<String, String>(this.kafkaProperties);
    }

    private void setProperties(){
        this.kafkaProperties = new Properties();
        this.kafkaProperties.setProperty("kafka_topic", kafkaConfig.getTopic());
        this.kafkaProperties.setProperty("kafka_username", kafkaConfig.getUsername());
        this.kafkaProperties.setProperty("kafka_password", kafkaConfig.getPassword());
        String jaasTemplate =
                "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
        String jaasCfg = String.format(jaasTemplate, kafkaConfig.getUsername(), kafkaConfig.getPassword());
        String serializer = StringSerializer.class.getName();
        String deserializer = StringDeserializer.class.getName();
        this.kafkaProperties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBrokers());
        this.kafkaProperties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializer);
        this.kafkaProperties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);

        this.kafkaProperties.put("session.timeout.ms", "30000");
        this.kafkaProperties.put("key.deserializer", deserializer);
        this.kafkaProperties.put("value.deserializer", deserializer);
        this.kafkaProperties.put("security.protocol", "SASL_SSL");
        this.kafkaProperties.put("sasl.mechanism", "SCRAM-SHA-256");
        this.kafkaProperties.put("sasl.jaas.config", jaasCfg);
    }

    public static KafkaClient getInstance() {
        if (soleInstance == null) { //if there is no instance available... create new one
            synchronized (KafkaClient.class) {
                if (soleInstance == null) soleInstance = new KafkaClient();
            }
        }
        return soleInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected KafkaClient readResolve() {
        return getInstance();
    }
}