package com.services.controller;

import com.services.configuration.Routes;
import com.services.service.rabbit.Consumer;
import com.services.service.rabbit.Producer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.APLICATION_NAME + Routes.API_VERSION + Routes.RESOURCE_CALLBACK_API)
public class MessagingController {
    private final static String QUEUE_NAME = "pedidos_node";
    private static String message = "";

    @PostMapping
    private static String Producer() throws Exception {
        Producer producer = new Producer();
        producer.setQUEUE_NAME(QUEUE_NAME);
        producer.setMessage(message);
        return producer.ProducerQueue();
    }

    @GetMapping
    private static String Consumer() throws Exception{
        Consumer consumer = new Consumer();
        consumer.setQUEUE_NAME(QUEUE_NAME);
        consumer.setMessage(message);
        return consumer.ConsumerQueue();
    }
}
