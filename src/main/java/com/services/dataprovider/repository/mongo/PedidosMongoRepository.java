package com.services.dataprovider.repository.mongo;

import com.services.dataprovider.repository.mongo.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidosMongoRepository extends MongoRepository<Pedido, String> {
}
