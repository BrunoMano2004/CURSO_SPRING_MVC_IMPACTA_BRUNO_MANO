package apilogin.apilogin.controller;

import apilogin.apilogin.client.BancoClient;
import apilogin.apilogin.client.CepClient;
import apilogin.apilogin.client.CriptClient;
import apilogin.apilogin.model.LoginTO;
import apilogin.apilogin.request.SenhaRequestDecrypt;
import apilogin.apilogin.response.CepResponse;
import apilogin.apilogin.response.UsuarioResponse;
import apilogin.apilogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    BancoClient bancoClient;

    @Autowired
    CriptClient criptClient;

    @Autowired
    LoginService service;

    @Autowired
    CepClient cepClient;

    SenhaRequestDecrypt senhaRequestDecrypt = new SenhaRequestDecrypt();

    CepResponse cepResponse = new CepResponse();

    @PostMapping("/login")
    public String login(@RequestBody LoginTO login){
        if (service.validacaoLogin(login))
            return "Login validado!";
        else
            return "Senha incorreta!";
    }


    @PostMapping("/cadastrarUsuario")
    public String cadastro(@RequestBody UsuarioResponse usuario){
        cepResponse = cepClient.pegarEndereco(usuario.getCep());

        usuario.setBairro(cepResponse.getBairro());
        usuario.setLogradouro(cepResponse.getLogradouro());
        bancoClient.cadastrarUsuario(usuario);

        return "Cadastro realizado com sucesso!";
    }
}
