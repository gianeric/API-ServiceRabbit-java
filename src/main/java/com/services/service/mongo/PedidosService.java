package com.services.service.mongo;

import com.services.dataprovider.model.Pedido;

import java.util.List;

public interface PedidosService {
    public List<Pedido> obterDados();

    public Pedido obterDadosPorCodigo(String codigo);

    public Pedido inserirDados(Pedido pedidos);
}
