package com.dinesh.springbootkafkaprotobuf.producer;

import com.dinesh.springbootkafkaprotobuf.model.OrderMessageOuterClass.OrderMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> stringKafkaTemplate;
    // Template expects byte[] now
    private final KafkaTemplate<String, byte[]> bytesKafkaTemplate;

    // Update template to expect OrderMessage object, not byte[]
    private final KafkaTemplate<String, OrderMessage> protobufKafkaTemplate;

    private static final String TOPIC = "demo-topic";
    private static final String PROTO_TOPIC = "protobuf-topic";

    public KafkaProducer(
            @Qualifier("stringKafkaTemplate") KafkaTemplate<String, String> stringKafkaTemplate,
            @Qualifier("bytesKafkaTemplate") KafkaTemplate<String, byte[]> bytesKafkaTemplate,
            @Qualifier("protobufKafkaTemplate") KafkaTemplate<String, OrderMessage> protobufKafkaTemplate) {
        this.stringKafkaTemplate = stringKafkaTemplate;
        this.bytesKafkaTemplate = bytesKafkaTemplate;
        this.protobufKafkaTemplate = protobufKafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("Sending String Message to Kafka: " + message);
        stringKafkaTemplate.send(TOPIC, message);
    }

    public void sendProtobufMessage(OrderMessage orderMessage) {
        // Convert Protobuf object natively to byte array
//        byte[] payload = orderMessage.toByteArray();
//
//        System.out.println("Sending Native Protobuf Bytes to Kafka: " + orderMessage);
//        bytesKafkaTemplate.send(PROTO_TOPIC, payload);

        // We now send the object directly. The Serializer registers it and converts it.
        System.out.println("Sending Protobuf Message to Kafka via Schema Registry: " + orderMessage);
        protobufKafkaTemplate.send(PROTO_TOPIC, orderMessage);
    }
}