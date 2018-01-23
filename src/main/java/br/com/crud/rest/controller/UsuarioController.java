package br.com.crud.rest.controller;

import br.com.crud.rest.dao.UsuarioDAO;
import br.com.crud.rest.daoImpl.UsuarioDAOImpl;
import br.com.crud.rest.dto.FiltroUsuarioDTO;
import br.com.crud.rest.dto.UsuarioDTO;
import br.com.crud.rest.exception.ServiceException;
import br.com.crud.rest.exception.ValidacaoException;
import br.com.crud.rest.model.Usuario;
import br.com.crud.rest.util.Util;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    public List<UsuarioDTO> listaUsuarios(FiltroUsuarioDTO filtro) throws Exception {
        UsuarioDAO dao = new UsuarioDAOImpl();
        List<UsuarioDTO> listUsuarioDTO = null;

        try {
            List<Usuario> usuarios = dao.listar(filtro);

            if (usuarios != null && !usuarios.isEmpty()) {
                listUsuarioDTO = new ArrayList<UsuarioDTO>();
                for (Usuario usuario : usuarios) {
                    listUsuarioDTO.add(new UsuarioDTO(usuario));
                }
            }
        } catch (Exception e) {
            throw new ServiceException();
        }

        return listUsuarioDTO;
    }

    public UsuarioDTO visualizaUsuario(Long id) throws Exception {
        UsuarioDAO dao = new UsuarioDAOImpl();
        Usuario usuario;

        try {
            usuario = dao.buscarPorId(id);
        } catch (Exception e) {
            throw new ServiceException();
        }

        return new UsuarioDTO(usuario);
    }

    public void atualizarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        UsuarioDAO dao = new UsuarioDAOImpl();
        Usuario usuario;

        if (usuarioDTO.getId() == null) {
            throw new ValidacaoException();
        }

        try {
            usuario = dao.buscarPorId(usuarioDTO.getId());

            if (usuarioDTO.getNome() != null) {
                usuario.setNome(usuarioDTO.getNome());
            }

            if (usuarioDTO.getDataNascimento() != null) {
                usuario.setDataNascimento(Util.parseDate(usuarioDTO.getDataNascimento()));
            }

            if (usuarioDTO.getGenero() != null) {
                usuario.setGenero(usuarioDTO.getGenero());
            }

            if (usuarioDTO.getCidade() != null) {
                usuario.setCidade(usuarioDTO.getCidade());
            }

            if (usuarioDTO.getEstado() != null) {
                usuario.setEstado(usuarioDTO.getEstado());
            }

            if (usuarioDTO.getCpfCnpj() != null) {
                if (!Util.validaCpfCnpj(usuarioDTO.getCpfCnpj())) {
                    throw new ValidacaoException();
                }
                usuario.setCpfCnpj(usuarioDTO.getCpfCnpj());
            }

            if (usuarioDTO.getSalarioReceita() != null) {
                usuario.setSalarioReceita(usuarioDTO.getSalarioReceita());
            }

            dao.salvar(usuario);

        } catch (Exception e) {
            throw new ServiceException();
        }
    }

    public void criarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        UsuarioDAO dao = new UsuarioDAOImpl();

        try {
            Usuario usuario = new Usuario();

            if (!validaUsuario(usuarioDTO)) {
                throw new ValidacaoException();
            }

            usuario.setNome(usuarioDTO.getNome());
            usuario.setDataNascimento(Util.parseDate(usuarioDTO.getDataNascimento()));
            usuario.setGenero(usuarioDTO.getGenero());
            usuario.setCidade(usuarioDTO.getCidade());
            usuario.setEstado(usuarioDTO.getEstado());
            usuario.setCpfCnpj(usuarioDTO.getCpfCnpj());
            usuario.setSalarioReceita(usuarioDTO.getSalarioReceita());

            dao.salvar(usuario);

        }catch (Exception e) {
            throw new ServiceException();
        }
    }

    public void apagarUsuario(Long id) throws Exception {
        UsuarioDAO dao = new UsuarioDAOImpl();

        try {
            dao.apagar(id);
        } catch (Exception e) {
            throw new ServiceException();
        }
    }

    private boolean validaUsuario(UsuarioDTO usuarioDTO) {

        if (usuarioDTO.getNome() == null || usuarioDTO.getNome().trim().equals("")) {
            return false;
        }

        if (usuarioDTO.getDataNascimento() == null) {
            return false;
        }

        if (usuarioDTO.getGenero() == null) {
            return false;
        }

        if (usuarioDTO.getEstado() == null) {
            return false;
        }

        if (usuarioDTO.getCidade() == null) {
            return false;
        }

        if (usuarioDTO.getCpfCnpj() == null || !Util.validaCpfCnpj(usuarioDTO.getCpfCnpj())) {
            return false;
        }

        if (usuarioDTO.getSalarioReceita() != null && usuarioDTO.getSalarioReceita().compareTo(0d) < 0) {
            return false;
        }

        return true;
    }

}
