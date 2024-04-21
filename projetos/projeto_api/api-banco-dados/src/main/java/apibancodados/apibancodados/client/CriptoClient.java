package apibancodados.apibancodados.client;

import apibancodados.apibancodados.request.SenhaRequestEncript;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cripto", url = "localhost:8080")
public interface CriptoClient {

    @PostMapping("/criptografar")
    String criptografarSenha(@RequestBody SenhaRequestEncript senha);
}
