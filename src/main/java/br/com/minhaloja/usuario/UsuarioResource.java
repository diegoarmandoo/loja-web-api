package br.com.minhaloja.usuario;

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
    
    private Usuario usuario;

    @GET
    @Produces(MediaType.APPLICATION_JSON)   
    public Response recuperar() {
        usuario = new Usuario(1, "Pedro", "pedro@mail.com", "1234");
        return Response.ok(usuario).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response recuperar(@PathParam("id") int id){

        usuario = new Usuario(id, "maria", "maria@mail.com", "3456");
        return Response.ok(usuario).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criar(Usuario usuario){
        //Chamar um repositoty ou um service para persisir esses dados.
        return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
    }

}
