package com.services.dataprovider.repository.sqlserver;

import com.services.dataprovider.repository.sqlserver.model.PedidoSQLServer;
import com.services.dataprovider.repository.sqlserver.model.PessoaSQLServer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PedidoSQLRepository extends CrudRepository<PedidoSQLServer, Integer> {
    PessoaSQLServer findByCodigoPedido(@Param("codigoPedido") Integer codigoPedido);
}
