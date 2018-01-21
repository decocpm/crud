package br.com.crud.rest.daoImpl;

import br.com.crud.rest.dao.AbstractDAO;
import br.com.crud.rest.dao.UsuarioDAO;
import br.com.crud.rest.dto.UsuarioDTO;
import br.com.crud.rest.model.Usuario;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl extends AbstractDAO<Long, Usuario> implements UsuarioDAO {

    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = null;

        if (valida(usuarioDTO)) {
            usuario = constroiUsuario(usuarioDTO);
            saveOrUpdate(usuario);
        }

        return new UsuarioDTO(usuario);
    }

    private Usuario constroiUsuario(UsuarioDTO usuarioDTO) {
        //TODO
        return new Usuario();
    }

    private boolean valida(UsuarioDTO usuarioDTO) {
        //TODO
        return true;
    }

    public void apagar(Long id) throws Exception {
        Usuario usuario = findById(id);
        delete(usuario);
    }

    public List<UsuarioDTO> listar(UsuarioDTO usuarioDTO) throws Exception {
        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>();

        //TODO criar query
        CriteriaQuery cq = getSession().getCriteriaBuilder().createQuery(Usuario.class);
        cq.from(Usuario.class);
        List<Usuario> usuarios = list(cq);

        if (usuarios != null && !usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                list.add(new UsuarioDTO((usuario)));
            }
        }

        return list;
    }

    public UsuarioDTO buscarPorId(Long id) throws Exception {
       Usuario usuario = findById(id);
       return new UsuarioDTO(usuario);
    }
}
