package apibancodados.apibancodados.client;
import apibancodados.apibancodados.response.CepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cep", url = "viacep.com.br/ws")
public interface CepClient {

    @GetMapping("/{cep}/json")
    CepResponse pegarEndereco(@PathVariable(name = "cep") String cpf);
}