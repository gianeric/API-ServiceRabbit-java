package com.services.service.mongo;

import com.services.dataprovider.repository.mongo.model.Pedido;

import java.util.List;

public interface PedidosMongoService {
    public List<Pedido> obterDados();

    public Pedido obterDadosPorCodigo(String codigo);

    public Pedido inserirDados(Pedido pedidos);
}
