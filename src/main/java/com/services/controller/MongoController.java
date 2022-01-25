package com.services.controller;

import com.services.configuration.Routes;
import com.services.dataprovider.repository.mongo.model.PedidoMongo;
import com.services.service.mongo.PedidosMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping(Routes.APLICATION_NAME_MONGO + Routes.API_VERSION_MONGO + Routes.RESOURCE_CALLBACK_API_MONGO)
public class MongoController {

    @Autowired
    private PedidosMongoService pedidosService;

    @GetMapping
    public List<PedidoMongo> obterDados() {
        return this.pedidosService.obterDados();
    }

    @GetMapping(path = "/{id}")
    public PedidoMongo obterDadosPorID(@PathVariable int id) {
        return this.pedidosService.obterDadosPorId(id);
    }

    @PostMapping
    public PedidoMongo inserirDados(@RequestBody PedidoMongo pedidos) {
        return this.pedidosService.inserirDados(pedidos);
    }

    @DeleteMapping(path = "/{id}")
    public PedidoMongo excluirDadosPorId(@PathVariable int id) {
        return this.pedidosService.excluirDadosPorId(id);
    }
}
