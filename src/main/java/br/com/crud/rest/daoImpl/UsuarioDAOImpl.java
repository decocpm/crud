package br.com.crud.rest.daoImpl;

import br.com.crud.rest.dao.AbstractDAO;
import br.com.crud.rest.dao.UsuarioDAO;
import br.com.crud.rest.dto.FiltroUsuarioDTO;
import br.com.crud.rest.model.Usuario;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class UsuarioDAOImpl extends AbstractDAO<Long, Usuario> implements UsuarioDAO {

    public void salvar(Usuario usuario) throws Exception {
        saveOrUpdate(usuario);
    }

    public void apagar(Long id) throws Exception {
        Usuario usuario = findById(id);
        delete(usuario);
    }

    public List<Usuario> listar(FiltroUsuarioDTO usuarioDTO) throws Exception {

        Transaction transaction = null;

        transaction = getSession().beginTransaction();

        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(usuario);

        if (usuarioDTO.getNomeSearch() != null) {
            cq.where(cb.like(usuario.<String>get(Usuario.NOME), usuarioDTO.getNomeSearch()));
        }

        if (usuarioDTO.getDataNascimentoInicioSearch() != null) {
            Path<Date> datePath = usuario.get("dataNascimento");
            cq.where(cb.greaterThanOrEqualTo(datePath, usuarioDTO.getDataNascimentoInicioSearch()));
        }

        if (usuarioDTO.getDataNascimentoFimSearch() != null) {
            Path<Date> datePath = usuario.get("dataNascimento");
            cq.where(cb.lessThanOrEqualTo(datePath, usuarioDTO.getDataNascimentoFimSearch()));
        }

        if (usuarioDTO.getGeneroSearch() != null) {
            cq.where(cb.equal(usuario.get(Usuario.GENERO), usuarioDTO.getGeneroSearch()));
        }

        if (usuarioDTO.getEstadoSearch() != null) {
            cq.where(cb.equal(usuario.get(Usuario.ESTADO), usuarioDTO.getEstadoSearch()));
        }

        if (usuarioDTO.getCidadeSearch() != null) {
            cq.where(cb.equal(usuario.get(Usuario.CIDADE), usuarioDTO.getCidadeSearch()));
        }

        if (usuarioDTO.getCpfCnpjSearch() != null) {
            cq.where(cb.equal(usuario.get("cpfCnpj"), usuarioDTO.getCpfCnpjSearch()));
        }

        cq.orderBy(cb.asc(usuario.get(Usuario.NOME)));

        return list(cq);
    }

    public Usuario buscarPorId(Long id) throws Exception {
       return findById(id);
    }
}
