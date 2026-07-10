package com.dinesh.springbootkafkaavro.controller;

import com.dinesh.springbootkafkaavro.dto.OrderDTO;
import com.dinesh.springbootkafkaavro.model.OrderMessage;
import com.dinesh.springbootkafkaavro.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducer kafkaProducer;

    @GetMapping
    public String sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return "Successfully sent message to Kafka: " + message;
    }

    @PostMapping("/json")
    public String sendJsonMessage(@RequestBody OrderDTO order){
        // Avro builder pattern
        OrderMessage orderMessage = OrderMessage.newBuilder()
                        .setOrderId(order.orderId)
                        .setProduct(order.product)
                        .setQuantity(order.quantity)
                        .build();
                        
        kafkaProducer.sendAvroMessage(orderMessage);
        return "Message sent : " + order;
    }
}