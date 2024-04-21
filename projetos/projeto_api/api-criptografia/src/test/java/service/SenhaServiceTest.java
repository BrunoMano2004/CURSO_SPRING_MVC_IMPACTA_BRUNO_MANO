package service;

import apicriptografia.apicriptografia.service.SenhaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SenhaServiceTest {

    @InjectMocks
    SenhaService senhaService;

    @Test
    public void criptografarSenhaTest(){
        String senha = "bruno2004";

        String senhaCriptografada = senhaService.encrypt(senha);

        assertNotEquals(senha, senhaCriptografada);
    }

    @Test
    public void descriptografarSenhaTest(){
        String senhaCriptografada = "joLvPT1/zNwuW+R7cgNRVg==";

        String senha = senhaService.decrypt(senhaCriptografada);

        assertNotEquals(senhaCriptografada, senha);
    }

    @Test
    public void cripDescripSenhaTest(){
        String senha = "bruno2004";

        String senha1 = senhaService.encrypt(senha);
        String senha2 = senhaService.decrypt(senha1);

        assertEquals(senha, senha2);
    }
}
