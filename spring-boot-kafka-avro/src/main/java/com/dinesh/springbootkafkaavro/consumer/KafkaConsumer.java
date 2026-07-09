package com.dinesh.springbootkafkaavro.consumer;

import com.dinesh.springbootkafkaavro.model.OrderMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord; // ADD THIS IMPORT
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "demo-topic", groupId = "demo-group",
            containerFactory = "stringKafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("Received message from Kafka: " + message);
    }

    // Listens for Avro messages
    @KafkaListener(
            topics = "avro-topic",
            groupId = "demo-group",
            containerFactory = "avroKafkaListenerContainerFactory"
    )
    public void consumeAvro(ConsumerRecord<String, OrderMessage> record) {
        // Extract the value directly from the record
        OrderMessage orderMessage = record.value();

        System.out.println("Received Avro Object from Kafka! " + orderMessage);
        System.out.println("Parsed Order Product: " + orderMessage.getProduct());
    }
}