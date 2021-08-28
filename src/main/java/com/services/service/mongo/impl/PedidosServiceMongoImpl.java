package com.services.service.mongo.impl;

import com.services.dataprovider.repository.mongo.model.Pedido;
import com.services.dataprovider.repository.mongo.PedidosMongoRepository;
import com.services.service.mongo.PedidosMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosServiceMongoImpl implements PedidosMongoService {

    @Autowired
    private PedidosMongoRepository pedidosRepository;

    @Override
    public List<Pedido> obterDados() {
        return this.pedidosRepository.findAll();
    }

    @Override
    public Pedido obterDadosPorCodigo(String codigo) {
        return this.pedidosRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não consta na base de dados."));
    }

    @Override
    public Pedido inserirDados(Pedido pedidos) {
        return this.pedidosRepository.save(pedidos);
    }
}
