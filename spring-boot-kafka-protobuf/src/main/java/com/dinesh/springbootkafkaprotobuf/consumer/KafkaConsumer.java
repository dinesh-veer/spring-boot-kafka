package com.dinesh.springbootkafkaprotobuf.consumer;

import com.dinesh.springbootkafkaprotobuf.model.OrderMessageOuterClass.OrderMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "demo-topic", groupId = "demo-group",
            containerFactory = "stringKafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("Received message from Kafka: " + message);
    }

    // Listens for raw byte arrays
//    @KafkaListener(
//            topics = "protobuf-topic",
//            groupId = "demo-group",
//            containerFactory = "bytesKafkaListenerContainerFactory"
//    )
//    public void consumeProtobuf(byte[] messageBytes) {
//        try {
//            // Reconstruct the Protobuf object natively from the byte array
//            OrderMessage orderMessage = OrderMessage.parseFrom(messageBytes);
//
//            System.out.println("Received Native Protobuf Bytes from Kafka! "+ orderMessage);
//            //System.out.println("Order ID: " + orderMessage.getOrderId());
//            System.out.println("Parsed Order Product: " + orderMessage.getProduct());
//            //System.out.println("Quantity: " + orderMessage.getQuantity());
//
//        } catch (InvalidProtocolBufferException e) {
//            System.err.println("Failed to deserialize Protobuf bytes!");
//            e.printStackTrace();
//        }
//    }

    @KafkaListener(
            topics = "protobuf-topic",
            groupId = "demo-group",
            containerFactory = "protobufKafkaListenerContainerFactory"
    )
    public void consumeProtobuf(OrderMessage orderMessage) {
        // No try/catch or parseFrom() needed!
        // The deserializer handles the bytes and the schema registry lookup.
        System.out.println("Received Protobuf object from Kafka! " + orderMessage);
        System.out.println("Parsed Order Product: " + orderMessage.getProduct());
    }
}