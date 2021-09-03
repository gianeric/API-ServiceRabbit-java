package com.services.dataprovider.repository.sqlserver;

import com.services.dataprovider.repository.sqlserver.model.PedidoItens;
import com.services.dataprovider.repository.sqlserver.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PedidoItensSQLRepository extends CrudRepository<PedidoItens, Integer> {
    Pessoa findByCodigoPedidoItem(@Param("codigoPedidoItem") Integer codigoPedidoItem);
}
