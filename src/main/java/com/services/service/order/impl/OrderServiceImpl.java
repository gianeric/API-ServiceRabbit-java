package com.services.service.order.impl;

import com.services.dataprovider.domain.PedidoDomain;
import com.services.dataprovider.repository.mongo.PedidosMongoRepository;
import com.services.dataprovider.repository.mongo.model.PedidoMongo;
import com.services.dataprovider.repository.sqlserver.PedidoItensSQLRepository;
import com.services.dataprovider.repository.sqlserver.PedidoSQLRepository;
import com.services.dataprovider.repository.sqlserver.PessoaSQLRepository;
import com.services.dataprovider.repository.sqlserver.model.PedidoItensSQLServer;
import com.services.dataprovider.repository.sqlserver.model.PedidoSQLServer;
import com.services.dataprovider.repository.sqlserver.model.PessoaSQLServer;
import com.services.service.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PedidosMongoRepository pedidosRepository;

    @Autowired
    private PedidoSQLRepository pedidosSQLServerRepository;

    @Autowired
    private PessoaSQLRepository pessoaSQLServerRepository;

    @Autowired
    private PedidoItensSQLRepository pedidoItensSQLServerRepository;

    @Override
    public PedidoDomain inserirDados(PedidoDomain pedido) {

        try {
            inserirDadosMongodb(pedido);
            inserirDadosSQLServer(pedido);
        } catch (Exception e) {
            log.error("Ocorreu um erro ao inserir o pedido de código {}", pedido.getCodigoPedido());
            log.error("Detalhes do Erro: {}", e.getMessage());
        }

        return pedido;
    }

    public void inserirDadosMongodb(PedidoDomain pedido) {
        log.info("Inserindo Pedido no MongoDB.");

        PedidoMongo pedidoMongoDB = new PedidoMongo();
        pedidoMongoDB.setId(pedido.hashCode());
        pedidoMongoDB.setCodigoPedido(pedido.getCodigoPedido());
        pedidoMongoDB.setDataPedido(Date.from(LocalDate.of(2022, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        pedidoMongoDB.setNomePedido(pedido.getNomePedido());
        pedidoMongoDB.setTipoPedido(pedido.getTipoPedido());
        pedidoMongoDB.setDadosPessoa(pedido.getPessoaPedido());
        pedidoMongoDB.setItensPedido(pedido.getPedidoItens());

        pedidosRepository.save(pedidoMongoDB);
        log.info("Pedido de código {} inserido no mongodb. Descrição: {}", pedido.getCodigoPedido(), pedido.getNomePedido());
    }

    public void inserirDadosSQLServer(PedidoDomain pedido) {
        log.info("Inserindo Pessoa no SQL Server.");
        PessoaSQLServer pessoaSQLServer = new PessoaSQLServer();
        pessoaSQLServer.setNomePessoa(pedido.getPessoaPedido().getNomePessoa());
        pessoaSQLServer.setDataNascimentoPessoa(pedido.getPessoaPedido().getDataNascimentoPessoa());

        log.info("Inserindo Itens do Pedido no SQL Server.");
        PedidoItensSQLServer pedidoItensSQLServer = new PedidoItensSQLServer();
        pedidoItensSQLServer.setDescricao(pedido.getPedidoItens().getDescricao());
        pedidoItensSQLServer.setValor(pedido.getPedidoItens().getValor());

        log.info("Inserindo Pedido no SQL Server.");
        PedidoSQLServer pedidoSQLServer = new PedidoSQLServer();
        pedidoSQLServer.setPessoaPedido(pessoaSQLServer);
        pedidoSQLServer.setNumeroPedido(pedido.getNumeroPedido());
        pedidoSQLServer.setDataPedido(pedido.getDataPedido());
        pedidoSQLServer.setNomePedido(pedido.getNomePedido());
        pedidoSQLServer.setTipoPedido(pedido.getTipoPedido());
        pedidoSQLServer.setPedidoItens(pedidoItensSQLServer);

        pessoaSQLServerRepository.save(pessoaSQLServer);
        pedidoItensSQLServerRepository.save(pedidoItensSQLServer);
        pedidosSQLServerRepository.save(pedidoSQLServer);
        log.info("Pedido de código {} inserido no SQL Server. Descrição: {}", pedido.getCodigoPedido(), pedido.getNomePedido());
    }
}
