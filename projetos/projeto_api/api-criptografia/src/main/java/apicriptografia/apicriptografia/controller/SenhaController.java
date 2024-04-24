package apicriptografia.apicriptografia.controller;

import apicriptografia.apicriptografia.request.SenhaRequestDecrypt;
import apicriptografia.apicriptografia.request.SenhaRequestEncript;
import apicriptografia.apicriptografia.security.AutClient;
import apicriptografia.apicriptografia.security.AutenticacaoService;
import apicriptografia.apicriptografia.service.SenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenhaController {

    @Autowired
    AutenticacaoService autenticacaoService;

    @Autowired
    private SenhaService senhaService;

    @PostMapping("/criptografar")
    public String criptografar(@RequestBody SenhaRequestEncript senha, @RequestHeader String token, @RequestHeader String authorization) throws Exception {
        autenticacaoService.autenticacaoService(token, authorization);

        return senhaService.encrypt(senha.getSenhaRequestEncript());
    }

    @PostMapping("/descriptografar")
    public String descriptografar(@RequestBody SenhaRequestDecrypt senha, @RequestHeader String token, @RequestHeader String authorization) throws Exception{
        autenticacaoService.autenticacaoService(token, authorization);

        return senhaService.decrypt(senha.getSenhaRequestDecrypt());
    }
}
