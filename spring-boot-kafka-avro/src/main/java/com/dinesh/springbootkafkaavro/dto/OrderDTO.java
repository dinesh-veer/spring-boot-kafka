package com.dinesh.springbootkafkaavro.dto;

import lombok.Data;

@Data
public class OrderDTO {
    public String orderId;
    public String product;
    public int quantity;
}