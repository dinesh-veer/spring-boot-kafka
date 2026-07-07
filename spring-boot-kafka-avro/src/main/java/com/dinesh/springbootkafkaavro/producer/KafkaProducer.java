package com.dinesh.springbootkafkaavro.producer;

import com.dinesh.springbootkafkaavro.model.OrderMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> stringKafkaTemplate;
    private final KafkaTemplate<String, OrderMessage> avroKafkaTemplate;

    private static final String TOPIC = "demo-topic";
    private static final String AVRO_TOPIC = "avro-topic";

    public KafkaProducer(
            @Qualifier("stringKafkaTemplate") KafkaTemplate<String, String> stringKafkaTemplate,
            @Qualifier("avroKafkaTemplate") KafkaTemplate<String, OrderMessage> avroKafkaTemplate) {
        this.stringKafkaTemplate = stringKafkaTemplate;
        this.avroKafkaTemplate = avroKafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("Sending String Message to Kafka: " + message);
        stringKafkaTemplate.send(TOPIC, message);
    }

    public void sendAvroMessage(OrderMessage orderMessage) {
        System.out.println("Sending Avro Object to Kafka: " + orderMessage);
        // The serializer handles communicating with the schema registry and converting to bytes automatically
        avroKafkaTemplate.send(AVRO_TOPIC, orderMessage);
    }
}