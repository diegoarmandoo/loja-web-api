package br.com.minhaloja.usuario;

import java.util.List;
import java.util.Optional;

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

    public Usuario atualizar(Usuario usuario) throws Exception {
        return usuariorepo.getById(usuario.getId()).map(u -> {
            u.setNome(usuario.getNome());
            u.setSenha(usuario.getSenha());
            u.setEmail(usuario.getEmail());
            usuariorepo.update(u);
            return u;
        }).orElseThrow(() -> new UsuarioNaoExisteException());
    }

    public void deletar(long id) throws Exception {
        Optional<Usuario> usuario = usuariorepo.getById(id);
        if (usuario.isPresent()) {
            usuariorepo.delete(usuario.get().getId());
        }
        else{
            throw new UsuarioNaoExisteException();
        }
    }

}
