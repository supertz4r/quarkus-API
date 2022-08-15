package org.project.controller.form;

import org.project.model.Categoria;

import javax.validation.constraints.*;

public class CategoriaForm {

    @NotNull
    private int codigo;

    @NotNull 
    @NotEmpty
    private String nomeCategoria;

    public int getId() {
        return codigo;
    }

    public void setId(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria convert() {
        return new Categoria(codigo, nomeCategoria);
    }
}
