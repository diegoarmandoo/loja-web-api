package br.com.minhaloja.usuario;

public class UsuarioException extends Exception {
    @Override
    public String getMessage(){
        return "";
    }
}

class UsuarioNaoExisteException extends UsuarioException {
    @Override
    public String getMessage(){
        return "O usuário não existe na base de dados.";
    }
}

class EmailInvalidoException extends UsuarioException {
    @Override
    public String getMessage(){
      return "O E-mail do usuário é invalido.";
    }
}