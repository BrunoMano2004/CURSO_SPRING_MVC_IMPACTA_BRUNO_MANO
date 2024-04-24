package apilogin.apilogin.client;

import apilogin.apilogin.request.SenhaRequestDecrypt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "descript", url = "localhost:8080")
public interface CriptClient {

    @PostMapping("/descriptografar")
    String descriptografarSenha(@RequestBody SenhaRequestDecrypt senha, @RequestHeader String token, @RequestHeader String authorization);
}
