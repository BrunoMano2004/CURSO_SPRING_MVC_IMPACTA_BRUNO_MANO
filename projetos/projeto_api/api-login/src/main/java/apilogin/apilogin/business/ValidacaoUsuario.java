package apilogin.apilogin.business;

import apilogin.apilogin.exception.IncorretDataException;
import apilogin.apilogin.response.UsuarioResponse;

public class ValidacaoUsuario {

    public boolean validacaoDados(UsuarioResponse usuario) throws IncorretDataException {
        if (!(usuario.getNome().length() > 5)){
            throw new IncorretDataException("Digite um nome que contenha mais de 5 caracteres!");
        }

        if (!(usuario.getSenha().contains("!"))
                && !(usuario.getSenha().contains("@"))
                && !(usuario.getSenha().contains("#"))
                && !(usuario.getSenha().contains("$"))
                && !(usuario.getSenha().contains("%"))
                && !(usuario.getSenha().contains("&"))){
            throw  new IncorretDataException("Digite uma senha que contenha pelo menos 1 caracter especial!");
        }
        return true;
    }
}
