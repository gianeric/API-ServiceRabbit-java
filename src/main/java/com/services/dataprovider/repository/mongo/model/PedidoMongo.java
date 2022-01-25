package com.services.dataprovider.repository.mongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PedidoMongo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private int codigoPedido;
    private Date dataPedido;
    private String nomePedido;
    private String tipoPedido;
    private Object dadosPessoa;
    private Object itensPedido;
}
