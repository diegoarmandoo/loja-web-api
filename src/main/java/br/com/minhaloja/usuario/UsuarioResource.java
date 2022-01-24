package br.com.minhaloja.usuario;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioResource {
    
    private UsuarioService usuarioService = new UsuarioService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public Response recuperar() {
        List<Usuario> listaUsuarios;
        try {
            listaUsuarios = usuarioService.listar();
        } catch (Exception e) {
           return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .type("text/plain")
                    .build();
        }
        return Response.ok(listaUsuarios, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response recuperar(@PathParam("id") int id){
        Usuario usuario;
        try {
            usuario = usuarioService.recuperar(id);
        } catch (Exception e) {
           return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .type("text/plain")
                    .build();
        }
        return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criar(Usuario usuario){
        int id;
        try {
            id = usuarioService.criar(usuario);
        } catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .type("text/plain")
                    .build();
        }
        return Response.ok(id, MediaType.APPLICATION_JSON).build();
    }

}
