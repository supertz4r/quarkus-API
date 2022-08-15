package org.project.controller.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.project.model.Categoria;
import org.project.model.Client;

public class ClientForm {

    @NotNull
    private int id;

    @NotNull 
    @NotEmpty 
    @Size(min = 5, max = 100)
    private String name;

    @NotNull 
    @Min(18)
    private int age;

    @Pattern(regexp = "^[a-zA-Z]{2}[0-9]{9}$")
    private String vatNumber;

    @NotNull 
    @NotEmpty
    private String email;

    @NotNull
    private Categoria categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Client convert() {
        return new Client(name, age, vatNumber, email, categoria);
    }
}
