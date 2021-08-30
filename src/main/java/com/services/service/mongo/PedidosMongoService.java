package com.services.service.mongo;

import com.services.dataprovider.repository.mongo.model.Pedido;

import java.util.List;

public interface PedidosMongoService {
    public List<Pedido> obterDados();

    public Pedido obterDadosPorId(int id);

    public Pedido inserirDados(Pedido pedidos);

    public Pedido excluirDadosPorId(int id);
}
