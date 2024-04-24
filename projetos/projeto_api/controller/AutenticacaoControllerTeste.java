package controller;

import apiaut.apiaut.controller.AutenticacaoController;
import apiaut.apiaut.exception.UnauthorizedException;
import apiaut.apiaut.model.AutenticacaoTO;
import apiaut.apiaut.repository.AutenticacaoRepository;
import apiaut.apiaut.service.AutenticacaoService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AutenticacaoControllerTeste {

    @Mock
    AutenticacaoRepository autenticacaoRepository;

    @InjectMocks
    AutenticacaoController autenticacaoController;

    @Test
    public void gerarTokenTest(){
        AutenticacaoTO autenticacao = autenticacaoController.gerarToken();

        assertNotEquals(null, autenticacao);
    }

    @Test
    public void autenticarTest_IfExists() throws UnauthorizedException {
        AutenticacaoTO autenticacao = new AutenticacaoTO();
        autenticacao.setAuthorization("wFRRytwKUmXRNwSAfeYlzdfxz");
        autenticacao.setXcsrfToken("ipGwEvQuhHnEgRDkuwfWjNOrCCzaoLPTntCRfEeErdyyWVqDuT");

        when(autenticacaoRepository.findByAuthorization(autenticacao.getAuthorization())).thenReturn(autenticacao);

        String resp = autenticacaoController.autenticar(autenticacao);

        assertEquals("Acesso autorizado", resp);
    }

}
