package com.services.dataprovider.repository.sqlserver;

import com.services.dataprovider.repository.sqlserver.model.PessoaSQLServer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PessoaSQLRepository extends CrudRepository<PessoaSQLServer, Integer> {
    PessoaSQLServer findByCodigoPessoa(@Param("codigoPessoa") Integer codigoPessoa);
}
