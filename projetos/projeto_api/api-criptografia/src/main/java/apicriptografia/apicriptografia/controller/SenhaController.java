package apicriptografia.apicriptografia.controller;

import apicriptografia.apicriptografia.request.SenhaRequestDecrypt;
import apicriptografia.apicriptografia.request.SenhaRequestEncript;
import apicriptografia.apicriptografia.service.SenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenhaController {

    @Autowired
    private SenhaService senhaService;

    @PostMapping("/criptografar")
    public String criptografar(@RequestBody SenhaRequestEncript senha) throws Exception {
        return senhaService.encrypt(senha.getSenhaRequestEncript());
    }

    @PostMapping("/descriptografar")
    public String descriptografar(@RequestBody SenhaRequestDecrypt senha) throws Exception{
        return senhaService.decrypt(senha.getSenhaRequestDecrypt());
    }
}
