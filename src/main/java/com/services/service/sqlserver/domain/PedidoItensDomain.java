package com.services.service.sqlserver.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoItensDomain {
    private Integer codigoPedidoItem;
    private String descricao;
    private BigDecimal valor;
}
