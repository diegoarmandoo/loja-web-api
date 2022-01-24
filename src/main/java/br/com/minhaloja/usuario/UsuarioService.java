package br.com.minhaloja.usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioService {
    
    private Usuario usuario;

    public int criar(Usuario usuario) throws Exception {
        int id;
        if (usuario.getEmail().equals("mail@.com")){
            //Email Válido
            id = usuario.getId();
        }
        else {
            //Email inválido   
			throw new  EmailInvalidoException();
        }
        return id;
    }

    public Usuario recuperar(int id) throws Exception {
        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> intList = new ArrayList<>(Arrays.asList(intArray));
        if (intList.contains(id)){
            //Usuario ele existe na base de dados
            usuario = new Usuario(id, "TesteArray", "Novo@mail.com", "2359");
        }
        else {
            //Usuarios não existe na base de dados
            throw new UsuarioNaoExisteException();
        }
        return usuario;
    }

    public List<Usuario> listar() throws Exception {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario(1, "User1", "user1@mail.com", "11111"));
        listaUsuarios.add(new Usuario(2, "User2", "user2@mail.com", "11111"));
        listaUsuarios.add(new Usuario(3, "User3", "user3@mail.com", "11111"));
        listaUsuarios.add(new Usuario(4, "User4", "user4@mail.com", "11111"));
        return listaUsuarios;
    }

}
