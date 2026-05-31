package com.dinesh.springbootkafkasimple.consumer;

import com.dinesh.springbootkafkasimple.model.OrderMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    // Listens to the String topic and uses the String factory
    @KafkaListener(topics = "demo-topic", groupId = "demo-group",
            containerFactory = "stringKafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("Received message from Kafka: " + message);
    }

    // Listens to the JSON topic and uses the JSON factory
    @KafkaListener(
            topics = "json-topic",
            groupId = "demo-group",
            containerFactory = "jsonKafkaListenerContainerFactory"
    )
    public void consumeJson(OrderMessage orderMessage) {
        System.out.println("Received JSON object from Kafka: " + orderMessage);
        System.out.println("Parsed Order Product: " + orderMessage.getProduct());
    }
}
