package com.services.dataprovider.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoItensDomain {
    @JsonProperty(value= "codigoPedidoItem")
    private Integer codigoPedidoItem;

    @JsonProperty(value= "descricao")
    private String descricao;

    @JsonProperty(value= "valor")
    private BigDecimal valor;
}
