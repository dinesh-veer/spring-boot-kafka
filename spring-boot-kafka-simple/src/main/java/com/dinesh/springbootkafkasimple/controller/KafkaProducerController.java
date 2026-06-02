package com.dinesh.springbootkafkasimple.controller;

import com.dinesh.springbootkafkasimple.model.OrderMessage;
import com.dinesh.springbootkafkasimple.producer.KafkaProducer;
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
    public String sendJsonMessage(@RequestBody OrderMessage order){
        kafkaProducer.sendJsonMessage(order);
        return "Message sent : " + order;

    }
}
