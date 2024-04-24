package apilogin.apilogin.client;

import apilogin.apilogin.response.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "banco", url = "localhost:8090")
public interface BancoClient {

    @GetMapping("/procurarCpf/{cpf}")
    UsuarioResponse procurarPeloCpf(@PathVariable(name = "cpf") long cpf, @RequestHeader String token, @RequestHeader String authorization);

    @PostMapping("/cadastrarUsuario")
    String cadastrarUsuario(@RequestBody UsuarioResponse usuario, @RequestHeader String token, @RequestHeader String authorization);
}
