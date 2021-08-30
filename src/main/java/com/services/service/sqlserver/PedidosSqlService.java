package com.services.service.sqlserver;


import com.services.dataprovider.repository.sqlserver.model.Pedido;

import java.util.List;

public interface PedidosSqlService {
    public List<Pedido> obterDados();

    public Pedido obterDadosPorCodigo(String codigo);

    public Pedido inserirDados(Pedido pedidos);
}