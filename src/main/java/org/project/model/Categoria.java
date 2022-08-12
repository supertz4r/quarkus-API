package org.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id 
    private int codigo;
    private String nomeCategoria;

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
