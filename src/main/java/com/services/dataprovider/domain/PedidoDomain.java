package com.services.dataprovider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PedidoDomain {
    @JsonProperty(value= "codigoPedido")
    private Integer codigoPedido;

    @JsonProperty(value= "numeroPedido")
    private Long numeroPedido;

    @JsonProperty(value= "dataPedido")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataPedido;

    @JsonProperty(value= "nomePedido")
    private String nomePedido;

    @JsonProperty(value= "tipoPedido")
    private String tipoPedido;

    @JsonProperty(value= "pessoaPedido")
    private PessoaDomain pessoaPedido;

    @JsonProperty(value= "pedidoItens")
    private PedidoItensDomain pedidoItens;
}
