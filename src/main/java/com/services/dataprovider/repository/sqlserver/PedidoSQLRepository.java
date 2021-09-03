package com.services.dataprovider.repository.sqlserver;

import com.services.dataprovider.repository.sqlserver.model.Pedido;
import com.services.dataprovider.repository.sqlserver.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PedidoSQLRepository extends CrudRepository<Pedido, Integer> {
    Pessoa findByCodigoPedido(@Param("codigoPedido") Integer codigoPedido);
}
