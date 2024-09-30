package com.example.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Lombok annotations to generate boilerplate code
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private String orderId;
    private String productName;
    private int quantity;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
