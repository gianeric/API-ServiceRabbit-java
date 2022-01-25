package com.services.service.mongo;

import com.services.dataprovider.repository.mongo.model.PedidoMongo;

import java.util.List;

public interface PedidosMongoService {
    public List<PedidoMongo> obterDados();

    public PedidoMongo obterDadosPorId(int id);

    public PedidoMongo inserirDados(PedidoMongo pedidos);

    public PedidoMongo excluirDadosPorId(int id);
}
