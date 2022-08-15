package org.project.controller.dto;

import org.project.model.Categoria;

public class CategoriaDto {
    private int codigo;
    private String nomeCategoria;

    public CategoriaDto(Categoria categoria) {
        this.codigo = categoria.getCodigo();
        this.nomeCategoria = categoria.getNomeCategoria();
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
