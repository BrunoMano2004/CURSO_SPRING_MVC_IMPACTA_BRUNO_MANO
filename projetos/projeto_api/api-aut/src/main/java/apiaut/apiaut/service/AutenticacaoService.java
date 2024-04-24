package apiaut.apiaut.service;

import apiaut.apiaut.model.AutenticacaoTO;
import apiaut.apiaut.repository.AutenticacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class AutenticacaoService {

    @Autowired
    AutenticacaoRepository autenticacaoRepository;

    public AutenticacaoTO gerarAutenticacao(){
        AutenticacaoTO autenticacao = new AutenticacaoTO();
        autenticacao.setAuthorization(gerarAuthorization());
        autenticacao.setXcsrfToken(gerarToken());

        return autenticacao;
    }

    public boolean validaAut(AutenticacaoTO autenticacao){
        AutenticacaoTO autenticacaoEncontrada = autenticacaoRepository.findByAuthorization(autenticacao.getAuthorization());

        if (autenticacaoEncontrada != null){
            if (autenticacaoEncontrada.getXcsrfToken().equals(autenticacao.getXcsrfToken())){
                if (autenticacaoEncontrada.getAuthorization().equals(autenticacao.getAuthorization())){
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public String gerarToken() {
        int tamanho = 50;
        SecureRandom random = new SecureRandom();
        StringBuilder tokenBuilder = new StringBuilder(tamanho);
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < tamanho; i++) {
            tokenBuilder.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return tokenBuilder.toString();
    }

    public String gerarAuthorization() {
        int tamanho = 25;
        SecureRandom random = new SecureRandom();
        StringBuilder tokenBuilder = new StringBuilder(tamanho);
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < tamanho; i++) {
            tokenBuilder.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return tokenBuilder.toString();
    }
}
