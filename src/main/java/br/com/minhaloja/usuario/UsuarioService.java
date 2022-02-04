package br.com.minhaloja.usuario;

import java.util.List;

public class UsuarioService {
    
    private UsuarioRepository usuariorepo = new UsuarioRepositoryJPA();

    public long criar(Usuario usuario) throws Exception {
        long id;
        if (usuario.getEmail().equals("mail@.com")){
            //Email válido
            usuariorepo.save(usuario);
            id = usuario.getId();
        }
        else {
            //Email inválido   
			throw new EmailInvalidoException();
        }
        return id;
    }

    public Usuario recuperar(long id) throws Exception {
        return usuariorepo.getById(id)
        .orElseThrow(() -> new UsuarioNaoExisteException());
    }

    public List<Usuario> listar() throws Exception {
        return usuariorepo.findAll();
    }

}
