package org.project.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.project.model.Client;

public class ClientDto {
    private Long id;
    private String name;
    private int age;
    private String vatNumber;
    private String email;

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.age = client.getAge();
        this.vatNumber = client.getVatNumber();
        this.email = client.getEmail();
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
}
