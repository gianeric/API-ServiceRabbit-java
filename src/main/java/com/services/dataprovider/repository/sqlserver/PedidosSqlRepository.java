package com.services.dataprovider.repository.sqlserver;

import com.services.dataprovider.repository.sqlserver.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidosSqlRepository extends CrudRepository<Pedido, String> {
}
