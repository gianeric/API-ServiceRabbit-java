package com.services.controller;

import com.services.configuration.Routes;
import com.services.dataprovider.repository.sqlserver.model.Pedido;
import com.services.service.sqlserver.PedidoServiceSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.APLICATION_NAME_SQL + Routes.API_VERSION_SQL + Routes.RESOURCE_CALLBACK_API_SQL)
public class SQLServerController {

    @Autowired
    private PedidoServiceSQL pedidosService;


    @GetMapping
    public List<Pedido> obterDados(){
        return this.pedidosService.obterDados();
    }

    @GetMapping("/codigo")
    public Pedido obterDadosPorID(@PathVariable Integer codigo){
        return this.pedidosService.obterDadosPorCodigo(codigo);
    }

    @PostMapping
    public Pedido inserirDados(@RequestBody Pedido pedidos){
        return this.pedidosService.inserirDados(pedidos);
    }
}
