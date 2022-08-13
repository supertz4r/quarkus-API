package org.project.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@Table(name="CLIENT")
@NamedNativeQueries({
    @NamedNativeQuery(name="CONSULTAR_CLIENT", query = "SELECT id, name, vatNumber, email from CLIENT", resultClass = Client.class),
    @NamedNativeQuery(name="CONSULTAR_CLIENT_ID", query = "SELECT id, name, vatNumber, email from CLIENT WHERE id = :idClient", resultClass = Client.class),
    @NamedNativeQuery(name="INSERIR_CLIENT", query = "INSERT INTO CLIENT (id, name, vatNumber, email) VALUES (:idClient, :nomeClient, :vatNumberClient, :emailClient);"),
    @NamedNativeQuery(name="ATUALIZAR_CLIENT", query = "UPDATE CLIENT SET nome = :nomeClient, vatNumber = :vatNumberClient, email = :emailClient WHERE id = :idClient "),
    @NamedNativeQuery(name="EXCLUIR_CLIENT", query = "DELETE CLIENT WHERE  id = :idClient"),
})
public class Client {

    @Id 
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String vatNumber;
    private String email;

    public Client() {}

    public Client(String name, int age, String vatNumber, String email) {
        this.name = name;
        this.age = age;
        this.vatNumber = vatNumber;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return vatNumber.equals(client.vatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatNumber);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
