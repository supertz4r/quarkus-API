package org.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@Table(name="CATEGORIA")
@NamedNativeQueries({
        @NamedNativeQuery(name="CONSULTAR_CATEGORIA", query = "SELECT codigo, nomeCategoria from CATEGORIA", resultClass = Categoria.class),
        @NamedNativeQuery(name="CONSULTAR_CATEGORIA_CODIGO", query = "SELECT codigo, nomeCategoria from CATEGORIA WHERE codigo = :codigoCategoria", resultClass = Categoria.class),
        @NamedNativeQuery(name="INSERIR_CATEGORIA", query = "INSERT INTO CATEGORIA (codigo, nomeCategoria) VALUES (:codigoCategoria, :nomeCategoriaCategoria);"),
        @NamedNativeQuery(name="ATUALIZAR_CATEGORIA", query = "UPDATE CATEGORIA SET nomeCategoria = :nomeCategoriaCategoria WHERE codigo = :codigoCategoria "),
        @NamedNativeQuery(name="EXCLUIR_CATEGORIA", query = "DELETE CATEGORIA WHERE codigo = :codigoCategoria"),
})
public class Categoria {

    @Id 
    private int codigo;
    private String nomeCategoria;

    public Categoria(int codigo, String nomeCategoria) {
        this.codigo = codigo;
        this.nomeCategoria = nomeCategoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}
