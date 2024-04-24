package service;

import apiaut.apiaut.model.AutenticacaoTO;
import apiaut.apiaut.repository.AutenticacaoRepository;
import apiaut.apiaut.service.AutenticacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AutenticacaoServiceTest {

    @Mock
    AutenticacaoRepository autenticacaoRepository;

    @InjectMocks
    AutenticacaoService autenticacaoService;

    @Test
    public void gerarAutoricacaoReturnTest(){
        assertEquals(autenticacaoService.gerarAutenticacao().getClass(), AutenticacaoTO.class);
    }

    @Test
    public void gerarAutenticacaoTeste(){
        AutenticacaoTO autenticacao1 = autenticacaoService.gerarAutenticacao();
        AutenticacaoTO autenticacao2 = autenticacaoService.gerarAutenticacao();

        assertNotEquals(autenticacao1, autenticacao2);
    }

    @Test
    public void gerarAuthorizationTest(){
        String authorization = autenticacaoService.gerarAuthorization();

        Assertions.assertEquals(authorization.length(), 25);
    }

    @Test
    public void gerarTokenTest(){
        String token = autenticacaoService.gerarToken();

        Assertions.assertEquals(token.length(), 50);
    }
}
