package org.project.service;

import org.eclipse.microprofile.opentracing.Traced;
import org.project.dao.CategoriaDao;
import org.project.model.Categoria;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.SQLException;

@RequestScoped
@Traced
public class CategoriaService {
    
    @Inject
    CategoriaDao dao;

    @Transactional(rollbackOn = Exception.class)
    public int inserirCategoria(Categoria categoria) throws SQLException{
        return dao.inserirCategoria(categoria);
    }

    @Transactional(rollbackOn = Exception.class)
    public int excluirCategoria(long codigo) throws SQLException {
        // Exemplo de regra para lancar exceção
        /* if(id == 1){
            throw new ErroNegocialException(ErrosSistema.ERRO_EXCLUSAO_Categoria.get().addVariavel(
                ChavesMonitoradasSistema.CPF.get(), id.toString()));
        } */

        return dao.excluirCategoria(codigo);
    }

    @Transactional(rollbackOn = Exception.class)
    public Object atualizarCategoria(long codigo, Categoria categoria) throws SQLException{
        return dao.atualizarCategoria(categoria);
    }

}
