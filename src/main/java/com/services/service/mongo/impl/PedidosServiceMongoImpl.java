package com.services.service.mongo.impl;

import com.services.dataprovider.repository.mongo.PedidosMongoRepository;
import com.services.dataprovider.repository.mongo.model.Pedido;
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
    public Pedido obterDadosPorId(int id) {
        return this.pedidosRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não consta na base de dados."));
    }

    @Override
    public Pedido inserirDados(Pedido pedidos) {
        return this.pedidosRepository.save(pedidos);
    }

    @Override
    public Pedido excluirDadosPorId(int id) {
        this.pedidosRepository.deleteById(id);
        return null;
    }
}
