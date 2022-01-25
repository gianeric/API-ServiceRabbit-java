package com.services.dataprovider.repository.mongo;

import com.services.dataprovider.repository.mongo.model.PedidoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidosMongoRepository extends MongoRepository<PedidoMongo, Integer> {
}
