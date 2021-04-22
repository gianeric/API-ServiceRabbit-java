package com.example.controller;

import org.springframework.web.bind.annotation.*;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/amqplib/callback_api")
public class MessagingController {
    private final static String QUEUE_NAME = "pedidos_spring";
    private String message = "";

    @PostMapping
    public static String Producer() throws Exception{
        String message;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            message =  "{"                                                       +
                       "data: 01/01/2021,"                                       +
                       "nome: Gian Eric,"                                        +
                       "servicos: [{descricao: Instalação do motor de arranque},"+
                       "{descricao: Instalação do amortecedor},"                 +
                       "{descricao: Troca da bomba de gasolina}]"                +
                       "}";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            return " [x] Sent. '" + message + "'";
        }
    }
}
