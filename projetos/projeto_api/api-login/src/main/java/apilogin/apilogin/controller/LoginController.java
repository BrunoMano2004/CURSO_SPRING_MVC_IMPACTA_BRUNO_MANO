package apilogin.apilogin.controller;

import apilogin.apilogin.business.ValidacaoUsuario;
import apilogin.apilogin.client.BancoClient;
import apilogin.apilogin.client.CepClient;
import apilogin.apilogin.client.CriptClient;
import apilogin.apilogin.exception.IncorretDataException;
import apilogin.apilogin.exception.UnauthorizedException;
import apilogin.apilogin.model.LoginTO;
import apilogin.apilogin.request.SenhaRequestDecrypt;
import apilogin.apilogin.response.CepResponse;
import apilogin.apilogin.response.UsuarioResponse;
import apilogin.apilogin.security.AutenticacaoService;
import apilogin.apilogin.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    LoginService service;

    ValidacaoUsuario validacaoUsuario = new ValidacaoUsuario();

    @Autowired
    BancoClient bancoClient;

    @Autowired
    AutenticacaoService autenticacaoService;

    @PostMapping("/loginForm")
    public String login(@RequestBody LoginTO login, @RequestHeader String token, @RequestHeader String authorization) throws UnauthorizedException {
        autenticacaoService.autenticacaoService(token, authorization);

        if (service.validacaoLogin(login, token, authorization)){
            return "Login Autorizado!";
        } else {
            throw new UnauthorizedException("Senha digitada incorreta!");
        }
    }

    @PostMapping("/cadastroUsuario")
    public String cadastro(@RequestBody UsuarioResponse usuario, @RequestHeader String token, @RequestHeader String authorization) throws IncorretDataException {
        autenticacaoService.autenticacaoService(token, authorization);

        validacaoUsuario.validacaoDados(usuario);

        bancoClient.cadastrarUsuario(usuario, token, authorization);

        return "Usuario cadastrado com sucesso!";
    }
}
