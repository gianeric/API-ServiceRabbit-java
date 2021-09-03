package com.services.dataprovider.repository.sqlserver;

import com.services.dataprovider.repository.sqlserver.model.PedidoItens;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PedidoItensSQLRepository extends CrudRepository<PedidoItens, Integer> {
    PedidoItens findByCodigoPedidoItem(@Param("codigoPedidoItem") Integer codigoPedidoItem);
}
