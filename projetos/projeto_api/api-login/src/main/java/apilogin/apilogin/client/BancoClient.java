package apilogin.apilogin.client;

import apilogin.apilogin.response.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "banco", url = "localhost:8090")
public interface BancoClient {

    @GetMapping("/procurarCpf/{cpf}")
    UsuarioResponse procurarPeloCpf(@PathVariable(name = "cpf") long cpf);

    @PostMapping("/cadastrarUsuario")
    String cadastrarUsuario(@RequestBody UsuarioResponse usuario);
}
