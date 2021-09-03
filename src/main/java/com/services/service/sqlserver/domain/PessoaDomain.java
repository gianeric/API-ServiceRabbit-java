package com.services.service.sqlserver.domain;

import com.services.dataprovider.repository.sqlserver.model.PedidoItens;
import com.services.dataprovider.repository.sqlserver.model.Pessoa;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaDomain {
    private Integer codigoPessoa;
    private String nomePessoa;
    private Date dataNascimentoPessoa;
}
