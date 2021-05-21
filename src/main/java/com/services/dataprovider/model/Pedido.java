package com.services.dataprovider.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Document
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String codigo;

    private Date data;
    private String nome;
    private String[] servicos;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getServicos() {
        return servicos;
    }

    public void setServicos(String[] servicos) {
        this.servicos = servicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return codigo.equals(pedido.codigo) && data.equals(pedido.data) && nome.equals(pedido.nome) && Arrays.equals(servicos, pedido.servicos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(codigo, data, nome);
        result = 31 * result + Arrays.hashCode(servicos);
        return result;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo='" + codigo + '\'' +
                ", data=" + data +
                ", nome='" + nome + '\'' +
                ", servicos=" + Arrays.toString(servicos) +
                '}';
    }
}
