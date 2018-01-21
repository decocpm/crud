package br.com.crud.rest.dao;

import br.com.crud.rest.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioDAO {

    UsuarioDTO salvar(UsuarioDTO usuarioDTO) throws Exception;

    void apagar(Long id) throws Exception;

    List<UsuarioDTO> listar(UsuarioDTO usuarioDTO) throws Exception;

    UsuarioDTO buscarPorId(Long id) throws Exception;
}
