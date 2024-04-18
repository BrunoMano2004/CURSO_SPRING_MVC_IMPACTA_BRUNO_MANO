package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import revisao_api.revisao_api.controller.PessoaController;
import revisao_api.revisao_api.exceptions.ResourceNotFoundException;
import revisao_api.revisao_api.model.PessoaTO;
import revisao_api.revisao_api.repository.PessoaRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaControllerTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaController pessoaController;

    @Test
    public void listarPessoaIdTest_IfExists() throws ResourceNotFoundException{
        //ID de teste
        long idTeste = 52;

        //Pessoa que o teste espera encontrar
        PessoaTO pessoaTeste = new PessoaTO();
        pessoaTeste.setId(52);
        pessoaTeste.setNome("Pedro Henrique");
        pessoaTeste.setEmail("pedro.hmcunha@gmail.com");
        pessoaTeste.setCpf("43546475858");

        //Simular a chamada do método findById()
        when(pessoaRepository.findById(idTeste)).thenReturn(Optional.of(pessoaTeste));

        ResponseEntity<PessoaTO> response = pessoaController.listarPessoaId(idTeste);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(pessoaTeste, response.getBody());

    }

    @Test
    public void listarPessoaIdTest_IfDoesntExists() throws ResourceNotFoundException{
        //ID simulado
        long idTeste = 11111L;

        when(pessoaRepository.findById(idTeste)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            pessoaController.listarPessoaId(idTeste);
        });

        assertEquals("Não existe pessoa com o ID: " + idTeste, exception.getLocalizedMessage());
    }

    @Test
    public void listaPessoasTest(){
        List<PessoaTO> pessoas = new ArrayList<>();

        pessoas.add(new PessoaTO(52L, "Pedro Henrique", "pedro.hmcunha@gmail.com", "43546475858"));
        pessoas.add(new PessoaTO(102L, "Bruno Mano", "bruno.mtfonseca@gmail.com", "5615616126"));

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        assertEquals(pessoas, pessoaController.listaPessoas());
    }

    @Test
    public void deletarPessoaTest_IfExists() throws ResourceNotFoundException{
        PessoaTO pessoaTeste = new PessoaTO(52L, "Pedro Henrique", "pedro.hmcunha@gmail.com", "43546475858");

        when(pessoaRepository.findById(pessoaTeste.getId())).thenReturn(Optional.of(pessoaTeste));

        assertEquals("Sucesso ao deletar!", pessoaController.deletarPessoa(pessoaTeste.getId()));
    }

    @Test
    public void deletarPessoaTest_IfDoesntExists() throws ResourceNotFoundException{
        long idTeste = 33636;

        ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            pessoaController.deletarPessoa(idTeste);
        });

        assertEquals("Não existe pessoa com o ID: " + idTeste, exception.getLocalizedMessage());
    }

    @Test
    public void atualizarPessoaTest_IfExists() throws ResourceNotFoundException{

        //É a pessoa esperada
        PessoaTO pessoaTest = new PessoaTO(102L, "Bruno Mano", "bruno.mtfonseca@gmail.com", "5615616126");
        PessoaTO pessoaTestAlterada = new PessoaTO(102L, "Bruno Fonseca", "bruno.mtfonseca@gmail.com", "343657674");

        when(pessoaRepository.findById(pessoaTest.getId())).thenReturn(Optional.of(pessoaTest));

        String response = pessoaController.atualizarPessoa(pessoaTestAlterada);

        assertEquals("Sucesso ao atualizar", response);
    }

    @Test
    public void atualizarPessoaTest_IfDoesntExists() throws ResourceNotFoundException{
        PessoaTO pessoaTest = new PessoaTO(435L, "Bruno Mano", "bruno.mtfonseca@gmail.com", "5615616126");

        when(pessoaRepository.findById(pessoaTest.getId())).thenReturn(Optional.empty());

        ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            pessoaController.deletarPessoa(pessoaTest.getId());
        });

        assertEquals("Não existe pessoa com o ID: " + pessoaTest.getId(), exception.getLocalizedMessage());
    }

    @Test
    public void cadastroPessoaTest(){
        PessoaTO pessoaTest = new PessoaTO(435L, "Bruno Mano", "bruno.mtfonseca@gmail.com", "5615616126");

        assertEquals(pessoaTest, pessoaController.cadastroPessoa(pessoaTest));
    }
}
