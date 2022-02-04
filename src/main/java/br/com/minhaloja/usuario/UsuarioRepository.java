package br.com.minhaloja.usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    
    Optional <Usuario> getById(Long id);
	Usuario save(Usuario usuario);
	Usuario update(Usuario usuario);
	void delete(Usuario usuario);
	List<Usuario> findAll();

}
