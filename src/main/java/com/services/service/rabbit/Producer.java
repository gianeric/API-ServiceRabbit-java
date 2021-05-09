package com.services.service.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Producer {
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

    public String ProducerQueue() throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
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
