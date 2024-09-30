package com.example.rabbitmq.controller;

import com.example.rabbitmq.service.OrderMessageService;
import com.example.rabbitmq.model.Order; // Import your Order model
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rabbitmq")
public class RabbitMQController {

    @Autowired
    private OrderMessageService orderMessageService;

    // Endpoint to manually send a message to RabbitMQ
    @PostMapping("/sendOrder")
    public String sendOrderToQueue(@RequestBody Order order) {
        orderMessageService.sendOrderMessage(order);
        return "Order sent to RabbitMQ queue!";
    }
}
