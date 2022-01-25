package com.services.service.order.impl;

import com.services.dataprovider.domain.PedidoDomain;
import com.services.dataprovider.repository.mongo.PedidosMongoRepository;
import com.services.dataprovider.repository.mongo.model.PedidoMongo;
import com.services.service.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PedidosMongoRepository pedidosRepository;

    @Override
    public PedidoDomain inserirDados(PedidoDomain pedido) {
        log.info("Inserindo Pedido.");

        PedidoMongo pedidoMongoDB = new PedidoMongo();
        //pedidoMongoDB.setId(pedido.hashCode());
        pedidoMongoDB.setCodigoPedido(pedido.getCodigoPedido());
        pedidoMongoDB.setDataPedido(Date.from(LocalDate.of(2022, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        pedidoMongoDB.setNomePedido(pedido.getNomePedido());
        pedidoMongoDB.setTipoPedido(pedido.getTipoPedido());
        pedidoMongoDB.setDadosPessoa(pedido.getPessoaPedido());
        pedidoMongoDB.setItensPedido(pedido.getPedidoItens());

        pedidosRepository.save(pedidoMongoDB);
        log.info("Pedido de código {} inserido no mongodb. Descrição: {}", pedido.getCodigoPedido(), pedido.getNomePedido());

        return pedido;
    }
}
