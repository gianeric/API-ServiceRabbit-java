package com.services.service.sqlserver.domain;

import com.services.dataprovider.repository.sqlserver.model.PedidoItens;
import com.services.dataprovider.repository.sqlserver.model.Pessoa;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDomain {
    private Integer codigoPedido;
    private Long numeroPedido;
    private Date dataPedido;
    private String nomePedido;
    private String tipoPedido;

    private List<Pessoa> pessoaPedido;
    private List<PedidoItens> pedidoItens;
}
