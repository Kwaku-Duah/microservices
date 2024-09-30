package com.example.rabbitmq.service;

import com.example.rabbitmq.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageService {

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.routing}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public OrderMessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Produce messages to RabbitMQ when an order is created
    public void sendOrderMessage(Order order) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, order);
        System.out.println("Order sent to RabbitMQ: " + order);
    }

    // Consume messages from RabbitMQ
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receiveOrderMessage(Order order) {
        System.out.println("Order received from RabbitMQ: " + order);
    }
}
