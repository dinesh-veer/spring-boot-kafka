package com.dinesh.springbootkafkasimple.producer;

import com.dinesh.springbootkafkasimple.model.OrderMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final KafkaTemplate<String, OrderMessage> jsonKafkaTemplate;


    private static final String TOPIC = "demo-topic";

    // Inject both templates using their specific bean names from the config class
    public KafkaProducer(
            @Qualifier("stringKafkaTemplate") KafkaTemplate<String, String> stringKafkaTemplate,
            @Qualifier("jsonKafkaTemplate") KafkaTemplate<String, OrderMessage> jsonKafkaTemplate) {

        this.stringKafkaTemplate = stringKafkaTemplate;
        this.jsonKafkaTemplate = jsonKafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("Sending Message to Kafka: " + message);
        stringKafkaTemplate.send(TOPIC, message);
    }

    public void sendJsonMessage(OrderMessage orderMessage) {
        System.out.println("Sending JSON Message to Kafka: " + orderMessage);
        jsonKafkaTemplate.send("json-topic", orderMessage);
    }
}
