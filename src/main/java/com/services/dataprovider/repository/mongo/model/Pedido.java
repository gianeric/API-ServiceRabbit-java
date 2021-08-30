package com.services.dataprovider.repository.mongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private int codigoPedido;
    private Object dadosPessoa;
    private Date dataPedido;
    private String nomePedido;
    private String tipoPedido;
    private Object itensPedido;
}
