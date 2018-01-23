package br.com.crud.rest.ws;

import br.com.crud.rest.controller.UsuarioController;
import br.com.crud.rest.dto.FiltroUsuarioDTO;
import br.com.crud.rest.dto.UsuarioDTO;
import br.com.crud.rest.exception.ServiceException;
import br.com.crud.rest.exception.ValidacaoException;
import br.com.crud.rest.model.Usuario;
import br.com.crud.rest.util.Util;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Path("/crud")
public class RESTfulCRUDResource {

    @GET
    @Path("/list/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("nome") String nome, @QueryParam("nascIni") String nascIni, @QueryParam("nascFim") String nascFim,
                         @QueryParam("genero") String genero, @QueryParam("estado") String estado, @QueryParam("cidade") String cidade,
                         @QueryParam("cpfCnpj") String cpfCnpj) {

        UsuarioController controller = new UsuarioController();
        String usuariosJson;

        try {
            FiltroUsuarioDTO filtro = new FiltroUsuarioDTO(nome, nascIni, nascFim, genero, estado, cidade, cpfCnpj);
            usuariosJson = Util.parseObjectToJson(controller.listaUsuarios(filtro));
        } catch (Exception e) {
            return Response.serverError().build();
        }

        return Response.ok(usuariosJson, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @GET
    @Path("/view/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response view(@PathParam("id") Long id) {

        UsuarioController controller = new UsuarioController();
        String usuarioJson;

        try {
            usuarioJson = Util.parseObjectToJson(controller.visualizaUsuario(id));
        } catch (Exception e) {
            return Response.serverError().build();
        }

        return Response.ok(usuarioJson, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @GET
    @Path("/update/{id}")
    public Response update(@PathParam("id") Long id, @QueryParam("nome") String nome, @QueryParam("dataNascimento") String dataNascimento, @QueryParam("genero") String genero, @QueryParam("estado") String estado,
                           @QueryParam("cidade") String cidade, @QueryParam("cpfCnpj") String cpfCnpj, @QueryParam("salarioReceita") String salarioReceita) {

        UsuarioController controller = new UsuarioController();

        try {
            UsuarioDTO usuario = new UsuarioDTO(id, nome, dataNascimento, genero, estado, cidade, cpfCnpj, salarioReceita);
            controller.atualizarUsuario(usuario);
        } catch (ValidacaoException ve) {
            return Response.serverError().entity("Erro de validação.").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }

        return Response.status(200).entity("OK").build();
    }

    @GET
    @Path("/create")
    public Response create(@QueryParam("nome") String nome, @QueryParam("dataNascimento") String dataNascimento, @QueryParam("genero") String genero, @QueryParam("estado") String estado,
                           @QueryParam("cidade") String cidade, @QueryParam("cpfCnpj") String cpfCnpj, @QueryParam("salarioReceita") String salarioReceita) {

        UsuarioController controller = new UsuarioController();

        try {
            UsuarioDTO usuario = new UsuarioDTO(null, nome, dataNascimento, genero, estado, cidade, cpfCnpj, salarioReceita);
            controller.criarUsuario(usuario);
        } catch (ValidacaoException ve) {
            return Response.serverError().entity("Erro de validação.").build();
        } catch (Exception e) {
            return Response.serverError().build();
        }

        return Response.status(200).entity("OK").build();
    }

    @GET
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {

        UsuarioController controller = new UsuarioController();

        try {
            controller.apagarUsuario(id);
        } catch (Exception e) {
            return Response.serverError().build();
        }

        return Response.status(200).entity("OK").build();
    }
}
