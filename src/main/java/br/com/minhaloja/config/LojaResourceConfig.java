package br.com.minhaloja.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import br.com.minhaloja.usuario.UsuarioResource;

@ApplicationPath("/")
public class LojaResourceConfig extends ResourceConfig {
    
    public LojaResourceConfig() {
        register(UsuarioResource.class);
    }

}
