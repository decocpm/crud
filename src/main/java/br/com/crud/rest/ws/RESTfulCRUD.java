package br.com.crud.rest.ws;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/")
public class RESTfulCRUD {

    @GET
    @Produces("text/html")
    public Response list() {
        return Response.status(200).entity("OK").build();
    }

    @GET
    @Produces("text/html")
    public Response view() {
        return Response.status(200).entity("OK").build();
    }

    @POST
    @Produces("text/html")
    public Response update() {
        return Response.status(200).entity("OK").build();
    }

    @POST
    @Produces("text/html")
    public Response create() {
        return Response.status(200).entity("OK").build();
    }

    @DELETE
    @Produces("text/html")
    public Response delete() {
        return Response.status(200).entity("OK").build();
    }
}
