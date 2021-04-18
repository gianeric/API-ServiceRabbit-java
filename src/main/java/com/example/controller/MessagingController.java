package com.example.controller;

import org.springframework.web.bind.annotation.*;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/amqplib/callback_api")
public class MessagingController {
    private final static String QUEUE_NAME = "hello";
    private String message;

    @PostMapping
    public String Producer() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            return " [x] Sent. '" + message + "'";
        }
    }

    @GetMapping
    public String Consumer() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println("[*] Waiting for messages.");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");

            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
            return " [x] Received '" + message + "'";
        }
    }


}
