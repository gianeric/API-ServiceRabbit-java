package com.services.service.sqlserver.impl;


import com.services.dataprovider.repository.sqlserver.PedidosSqlRepository;
import com.services.dataprovider.repository.sqlserver.model.Pedido;
import com.services.service.sqlserver.PedidosSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosServiceSqlImpl implements PedidosSqlService {

    @Autowired
    private PedidosSqlRepository pedidosRepository;

    @Override
    public List<Pedido> obterDados() {
        return (List<Pedido>) this.pedidosRepository.findAll();
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