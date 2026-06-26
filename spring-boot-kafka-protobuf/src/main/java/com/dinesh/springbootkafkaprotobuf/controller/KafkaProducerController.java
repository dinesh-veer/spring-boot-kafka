package com.dinesh.springbootkafkaprotobuf.controller;

import com.dinesh.springbootkafkaprotobuf.dto.OrderDTO;
import com.dinesh.springbootkafkaprotobuf.model.OrderMessageOuterClass.OrderMessage;
import com.dinesh.springbootkafkaprotobuf.producer.KafkaProducer;
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
        OrderMessage orderMessage = OrderMessage.newBuilder()
                        .setOrderId(order.orderId)
                                .setProduct(order.product)
                                        .setQuantity(order.quantity).build();
        kafkaProducer.sendProtobufMessage(orderMessage);
        return "Message sent : " + order;

    }
}
