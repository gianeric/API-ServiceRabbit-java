package com.services.dataprovider.repository.sqlserver;

import com.services.dataprovider.repository.sqlserver.model.PedidoItensSQLServer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PedidoItensSQLRepository extends CrudRepository<PedidoItensSQLServer, Integer> {
    PedidoItensSQLServer findByCodigoPedidoItem(@Param("codigoPedidoItem") Integer codigoPedidoItem);
}
