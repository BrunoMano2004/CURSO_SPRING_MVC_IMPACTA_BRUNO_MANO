package apiaut.apiaut.controller;

import apiaut.apiaut.exception.UnauthorizedException;
import apiaut.apiaut.model.AutenticacaoTO;
import apiaut.apiaut.repository.AutenticacaoRepository;
import apiaut.apiaut.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutenticacaoController {

    @Autowired
    AutenticacaoService autenticacaoService;


    @Autowired
    AutenticacaoRepository autenticacaoRepository;

    @GetMapping("/gerarAutenticacao")
    public AutenticacaoTO gerarToken(){
        AutenticacaoTO autenticacao = autenticacao = autenticacaoService.gerarAutenticacao();
        autenticacaoRepository.save(autenticacao);
        return autenticacao;
    }

    @PostMapping("/autenticar")
    public String autenticar(@RequestBody AutenticacaoTO autenticao) throws UnauthorizedException {
        if (!(autenticacaoService.validaAut(autenticao))){
            throw new UnauthorizedException("Token ou Authorization errados!");
        } else {
            return "Acesso autorizado";
        }
    }
}
