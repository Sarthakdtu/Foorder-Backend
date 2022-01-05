package com.foorder.kafkaUtils;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class KafkaConfig implements Serializable{

    Logger logger = LoggerFactory.getLogger(KafkaConfig.class.getName());

    private static volatile KafkaConfig soleInstance;

    @Getter @Setter private String username;

    @Getter @Setter private String password;

    @Getter @Setter private String topic;

    @Getter @Setter private String brokers;

    public KafkaConfig(){
        if (soleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        logger.info("Loading properties from kafka.properties");
        Properties properties = loadProperties();
        logger.info("Property loading complete");
        this.setUsername(properties.getProperty("kafka.username"));
        this.setPassword(properties.getProperty("kafka.password"));
        this.setTopic(this.getUsername() + "-" + properties.getProperty("kafka.topic"));
        this.setBrokers(properties.getProperty("kafka.brokers"));
    }

    private Properties loadProperties(){
        File file = new File("src/main/resources/kafka.properties");
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(file)) {
            // load a properties file
            prop.load(input);
            // get the property value and print it out
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

    public static KafkaConfig getInstance() {
        if (soleInstance == null) { //if there is no instance available... create new one
            synchronized (KafkaConfig.class) {
                if (soleInstance == null) soleInstance = new KafkaConfig();
            }
        }
        return soleInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected KafkaConfig readResolve() {
        return getInstance();
    }

    @Override
    public String toString() {
        return "KafkaConfig{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", topic='" + topic + '\'' +
                ", brokers='" + brokers + '\'' +
                '}';
    }
}

