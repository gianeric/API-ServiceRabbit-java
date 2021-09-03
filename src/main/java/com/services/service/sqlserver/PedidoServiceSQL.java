package com.services.service.sqlserver;


import com.services.dataprovider.repository.sqlserver.model.Pedido;

import java.util.List;

public interface PedidoServiceSQL {
    public List<Pedido> obterDados();

    public Pedido obterDadosPorCodigo(Integer codigo);

    public Pedido inserirDados(Pedido pedidos);
}