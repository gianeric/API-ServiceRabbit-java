package com.services.repository;

import com.services.dataprovider.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidosRepository extends MongoRepository<Pedido, String> {
}
