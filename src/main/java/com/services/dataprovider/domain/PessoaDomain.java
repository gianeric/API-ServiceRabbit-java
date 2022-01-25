package com.services.dataprovider.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaDomain {
    @JsonProperty(value= "codigoPessoa")
    private Integer codigoPessoa;

    @JsonProperty(value= "nomePessoa")
    private String nomePessoa;

    @JsonProperty(value= "dataNascimentoPessoa")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dataNascimentoPessoa;
}
