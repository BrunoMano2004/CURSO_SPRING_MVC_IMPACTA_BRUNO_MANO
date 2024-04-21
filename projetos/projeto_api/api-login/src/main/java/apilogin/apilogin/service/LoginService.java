package apilogin.apilogin.service;

import apilogin.apilogin.client.BancoClient;
import apilogin.apilogin.client.CriptClient;
import apilogin.apilogin.model.LoginTO;
import apilogin.apilogin.request.SenhaRequestDecrypt;
import apilogin.apilogin.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    BancoClient bancoClient;

    @Autowired
    CriptClient criptClient;

    UsuarioResponse usuario = new UsuarioResponse();

    SenhaRequestDecrypt senha = new SenhaRequestDecrypt();

    public boolean validacaoLogin(LoginTO login){
        usuario = bancoClient.procurarPeloCpf(login.getCpf());
        senha.setSenhaRequestDecrypt(usuario.getSenha());
        usuario.setSenha(criptClient.descriptografarSenha(senha));

        return login.getSenha().equals(usuario.getSenha());
    }
}
