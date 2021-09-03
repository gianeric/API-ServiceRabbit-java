package com.services.dataprovider.repository.sqlserver;

import com.services.dataprovider.repository.sqlserver.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PessoaSQLRepository extends CrudRepository<Pessoa, Integer> {
    Pessoa findByCodigoPessoa(@Param("codigoPessoa") Integer codigoPessoa);
}
