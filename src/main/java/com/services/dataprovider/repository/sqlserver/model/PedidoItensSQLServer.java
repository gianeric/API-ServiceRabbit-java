package com.services.dataprovider.repository.sqlserver.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "pedidos_itens", schema="dbo")
public class PedidoItensSQLServer implements Serializable {
    private static final long serialVersionUID = -1408030468442129411L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pedido_item", nullable = false)
    private Integer codigoPedidoItem;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Column(name = "valor", precision = 19, scale = 2, nullable = false)
    private BigDecimal valor;
}
