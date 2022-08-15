package org.project.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.project.model.Categoria;
import org.project.model.Client;

public class ClientDto {
    private Long id;
    private String name;
    private int age;
    private String vatNumber;
    private String email;

    private Categoria categoria;

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.age = client.getAge();
        this.vatNumber = client.getVatNumber();
        this.email = client.getEmail();
        this.categoria = client.getCategoria();
    }

    public static List<ClientDto> convert(List<Client> clients) {
        return clients.stream().map(ClientDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public String getEmail() {
        return email;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
