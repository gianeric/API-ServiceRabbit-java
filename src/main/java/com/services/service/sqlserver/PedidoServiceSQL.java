package com.services.service.sqlserver;


import com.services.dataprovider.repository.sqlserver.model.PedidoSQLServer;

import java.util.List;

public interface PedidoServiceSQL {
    public List<PedidoSQLServer> obterDados();

    public PedidoSQLServer obterDadosPorCodigo(Integer codigo);

    public PedidoSQLServer inserirDados(PedidoSQLServer pedidos);
}