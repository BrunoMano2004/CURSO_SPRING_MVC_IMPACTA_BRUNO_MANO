package repository;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import revisao_api.revisao_api.model.PessoaTO;
import revisao_api.revisao_api.repository.PessoaRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PessoaRepositoryTest {

    @Mock
    PessoaRepository pessoaRepository;

    @Test
    public void findByIdTest(){
        PessoaTO pessoaTeste = new PessoaTO();

        pessoaTeste.setId(34);
        pessoaTeste.setNome("Teste");
        pessoaTeste.setEmail("teste@teste.com");
        pessoaTeste.setCpf("testeteste");

        assertEquals(pessoaTeste, pessoaRepository.findById(pessoaTeste.getId()));
    }
}
