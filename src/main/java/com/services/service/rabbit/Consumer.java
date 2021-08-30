package com.services.service.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.util.ArrayList;

public class Consumer {
    private String QUEUE_NAME;
    private String message;

    public String getQUEUE_NAME() {
        return QUEUE_NAME;
    }

    public void setQUEUE_NAME(String QUEUE_NAME) {
        this.QUEUE_NAME = QUEUE_NAME;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String ConsumerQueue() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println("[*] Waiting for messages.");

        channel.basicQos(1);

        //Wait messages
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
        return " [x] Received";
    }
}
