package apibancodados.apibancodados.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    AutClient autClient;

    public void autenticacaoService(String token, String authorization){
        AutenticacaoTO autenticacao = new AutenticacaoTO();
        autenticacao.setAuthorization(authorization);
        autenticacao.setXcsrfToken(token);

        autClient.autenticarEntrada(autenticacao);
    }

}
