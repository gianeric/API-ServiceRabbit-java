package com.services.dataprovider.repository.sqlserver.model;

import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "pedidos", schema="dbo")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 8011413255131735002L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pedido", nullable = false)
    private Integer codigoPedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo_pessoa", nullable = false)
    private Pessoa pessoaPedido;

    @Column(name = "numero_pedido", nullable = false)
    private Long numeroPedido;

    @Column(name = "data_pedido", nullable = false)
    private LocalDate dataPedido;

    @Column(name = "nome_pedido", length = 255)
    private String nomePedido;

    @Column(name = "tipo_pedido", length = 50, nullable = false)
    private String tipoPedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "codigo_pedido_item", nullable = false)
    private PedidoItens pedidoItens;
}
