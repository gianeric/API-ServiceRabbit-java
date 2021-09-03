package com.services.service.sqlserver.impl;


import com.services.dataprovider.repository.sqlserver.PedidoItensSQLRepository;
import com.services.dataprovider.repository.sqlserver.PedidoSQLRepository;
import com.services.dataprovider.repository.sqlserver.PessoaSQLRepository;
import com.services.dataprovider.repository.sqlserver.model.Pedido;
import com.services.service.sqlserver.PedidoServiceSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceSQLImpl implements PedidoServiceSQL {

    @Autowired
    private PedidoSQLRepository pedidosRepository;

    @Autowired
    private PessoaSQLRepository pessoaSqlRepository;

    @Autowired
    private PedidoItensSQLRepository pedidoItensSqlRepository;

    @Override
    public List<Pedido> obterDados() {
        return (List<Pedido>) this.pedidosRepository.findAll();
    }

    @Override
    public Pedido obterDadosPorCodigo(Integer codigo) {
        return this.pedidosRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não consta na base de dados."));
    }

    @Override
    public Pedido inserirDados(Pedido pedidos) {
        this.pessoaSqlRepository.save(pedidos.getPessoaPedido());
        this.pedidoItensSqlRepository.save(pedidos.getPedidoItens());
        this.pedidosRepository.save(pedidos);

        return pedidos;
    }
}