package com.dinesh.springbootkafkasimple.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage {
    private String orderId;
    private String product;
    private int quantity;
}