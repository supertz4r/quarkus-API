package org.project.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.sql.SQLException;

import org.eclipse.microprofile.opentracing.Traced;
import org.project.dao.ClientDao;
import org.project.model.Client;

@RequestScoped
@Traced
public class ClientService {
    
    @Inject
    ClientDao dao;

    @Transactional(rollbackOn = Exception.class)
    public int inserirClient(Client client) throws SQLException{
        return dao.inserirClient(client);
    }

    @Transactional(rollbackOn = Exception.class)
    public int excluirClient(long id) throws SQLException {
        // Exemplo de regra para lancar exceção
        /* if(id == 1){
            throw new ErroNegocialException(ErrosSistema.ERRO_EXCLUSAO_CLIENT.get().addVariavel(
                ChavesMonitoradasSistema.CPF.get(), id.toString()));
        } */

        return dao.excluirClient(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public Object atualizarClient(long id, Client client) throws SQLException{
        return dao.atualizarClient(client);
    }

}
