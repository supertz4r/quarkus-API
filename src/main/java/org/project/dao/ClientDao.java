package org.project.dao;

import org.project.controller.dto.ClientDto;
import org.project.controller.form.ClientForm;
import org.project.model.Client;
import org.project.repository.ClientRepository;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Traced
@RequestScoped
public class ClientDao {

    @PersistenceContext
    EntityManager em;

    public List<Client> buscaClients() throws ErroSqlException {
        String nameQuery = "CONSULTAR_CLIENT";

        TypedQuery<Client> query = em
                .createNamedQuery(nameQuery, Client.class);

        try {
            return query.getResultList();
        } catch (NoResultException e){
            return new ArrayList<>();
        } catch (PersistenceException e){
            throw new ErroSqlException(e);
        }
    }

    public Client buscarClient(Long id) throws ErroSqlException {
        String nameQuery = "CONSULTAR_CLIENT_ID";

        TypedQuery<Client> query = em
                .createNamedQuery(nameQuery, Client.class);

        query.setParameter("idClient", id);

        try {
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        } catch (PersistenceException e){
            throw new ErroSqlException(e);
        }
    }

    @Transactional
    public int inserirClient(Client client) throws ErroSqlException {
        String nameQuery = "INSERIR_CLIENT";
        return insertOrUpdate(client, nameQuery);
    }

    @Transactional
    public int excluirClient(long id) throws ErroSqlException {
        String nameQuery = "EXCLUIR_CLIENT";

        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("idClient", id);

        try {
            return query.executeUpdate();
        } catch (NoResultException e){
            return 0;
        } catch (PersistenceException e){
            throw new ErroSqlException(e);
        }
    }

    @Transactional
    public int atualizarClient(Client client) throws ErroSqlException {
        String nameQuery = "ATUALIZAR_CLIENT";
        return insertOrUpdate(client, nameQuery);
    }

    @Transactional
    private int insertOrUpdate(Client client, String nameQuery) throws ErroSqlException {
        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("idClient", client.getId());
        query.setParameter("nomeClient", client.getName());
        query.setParameter("vatNumberClient", client.getVatNumber());
        query.setParameter("emailClient", client.getEmail());


        try {
            return query.executeUpdate();
        } catch (NoResultException e) {
            return 0;
        } catch (PersistenceException e) {
            throw new ErroSqlException(e);
        }
    }

}
