package br.com.crud.rest.dao;

import br.com.crud.rest.dto.FiltroUsuarioDTO;
import br.com.crud.rest.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void salvar(Usuario usuario) throws Exception;

    void apagar(Long id) throws Exception;

    List<Usuario> listar(FiltroUsuarioDTO usuarioDTO) throws Exception;

    Usuario buscarPorId(Long id) throws Exception;
}
