package com.services.service.mongo.impl;

import com.services.dataprovider.model.Pedido;
import com.services.repository.PedidosRepository;
import com.services.service.mongo.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosServiceImpl implements PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

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
