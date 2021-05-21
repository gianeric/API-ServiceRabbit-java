package com.services.controller;

import com.services.configuration.Routes;
import com.services.dataprovider.model.Pedido;
import com.services.service.mongo.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.APLICATION_NAME_MONGO + Routes.API_VERSION_MONGO + Routes.RESOURCE_CALLBACK_API_MONGO)
public class MongoController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping
    public List<Pedido> obterDados(){
        return this.pedidosService.obterDados();
    }

    @GetMapping("/codigo")
    public Pedido obterDadosPorID(@PathVariable String codigo){
        return this.pedidosService.obterDadosPorCodigo(codigo);
    }

    @PostMapping
    public Pedido inserirDados(@RequestBody Pedido pedidos){
        return this.pedidosService.inserirDados(pedidos);
    }
}
