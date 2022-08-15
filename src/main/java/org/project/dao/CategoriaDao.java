package org.project.dao;

import org.eclipse.microprofile.opentracing.Traced;
import org.project.model.Categoria;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Traced
@RequestScoped
public class CategoriaDao {

    @PersistenceContext
    EntityManager em;

    public List<Categoria> buscaCategorias() throws SQLException {
        String nameQuery = "CONSULTAR_CATEGORIA";

        TypedQuery<Categoria> query = em
                .createNamedQuery(nameQuery, Categoria.class);

        try {
            return query.getResultList();
        } catch (NoResultException e){
            return new ArrayList<>();
        } catch (PersistenceException e){
            throw new SQLException(e);
        }
    }

    public Categoria buscarCategoria(long codigo) throws SQLException {
        String nameQuery = "CONSULTAR_CATEGORIA_CODIGO";

        TypedQuery<Categoria> query = em
                .createNamedQuery(nameQuery, Categoria.class);

        query.setParameter("codigoCategoria", codigo);

        try {
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        } catch (PersistenceException e){
            throw new SQLException(e);
        }
    }

    @Transactional
    public int inserirCategoria(Categoria categoria) throws SQLException {
        String nameQuery = "INSERIR_CATEGORIA";
        return insertOrUpdate(categoria, nameQuery);
    }

    @Transactional
    public int excluirCategoria(long codigo) throws SQLException {
        String nameQuery = "EXCLUIR_CATEGORIA";

        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("codigoCategoria", codigo);

        try {
            return query.executeUpdate();
        } catch (NoResultException e){
            return 0;
        } catch (PersistenceException e){
            throw new SQLException(e);
        }
    }

    @Transactional
    public int atualizarCategoria(Categoria categoria) throws SQLException {
        String nameQuery = "ATUALIZAR_CATEGORIA";
        return insertOrUpdate(categoria, nameQuery);
    }

    @Transactional
    private int insertOrUpdate(Categoria categoria, String nameQuery) throws SQLException {
        Query query = em
                .createNamedQuery(nameQuery);

        query.setParameter("codigoCategoria", categoria.getCodigo());
        query.setParameter("nomeCategoriaCategoria", categoria.getNomeCategoria());

        try {
            return query.executeUpdate();
        } catch (NoResultException e) {
            return 0;
        } catch (PersistenceException e) {
            throw new SQLException(e);
        }
    }

}
