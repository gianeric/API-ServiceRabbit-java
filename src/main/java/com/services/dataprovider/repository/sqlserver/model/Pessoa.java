package com.services.dataprovider.repository.sqlserver.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "pessoas", schema="dbo")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 2601164526954693755L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pessoa")
    private Integer codigoPessoa;

    @Column(name = "nome_pessoa", length = 255)
    private String nomePessoa;

    @Column(name = "data_nascimento_pessoa")
    private LocalDate dataNascimentoPessoa;
}