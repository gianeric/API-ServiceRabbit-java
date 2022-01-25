package com.services.controller;

import com.services.configuration.Routes;
import com.services.dataprovider.domain.PedidoDomain;
import com.services.dataprovider.repository.mongo.model.Pedido;
import com.services.service.mongo.PedidosMongoService;
import com.services.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
@RequestMapping(Routes.APLICATION_NAME + Routes.API_VERSION + Routes.RESOURCE_CALLBACK_API)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public PedidoDomain inserirDados(@RequestBody PedidoDomain pedido) {
        return orderService.inserirDados(pedido);
    }
}
