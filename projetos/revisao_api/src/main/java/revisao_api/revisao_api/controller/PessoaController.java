package revisao_api.revisao_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import revisao_api.revisao_api.exceptions.ResourceNotFoundException;
import revisao_api.revisao_api.model.PessoaTO;
import revisao_api.revisao_api.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/listaPessoasRota")
    public List<PessoaTO> listaPessoas(){
        List<PessoaTO> pessoas = (List<PessoaTO>)pessoaRepository.findAll();

        return pessoas;
    }

    @PostMapping("/cadastroPessoaRota")
    public PessoaTO cadastroPessoa(@RequestBody PessoaTO pessoa){
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    @DeleteMapping("/Pessoa/{id}")
    public String deletarPessoa(@PathVariable(name = "id") long id)
            throws ResourceNotFoundException {
                PessoaTO pessoa =
                        pessoaRepository
                                .findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + id));
                pessoaRepository.deleteById(id);

        return "Sucesso ao deletar!";
    }

    @GetMapping("/Pessoa/{id}")
    public ResponseEntity<PessoaTO> listarPessoaId(@PathVariable(name = "id") long id)
        throws ResourceNotFoundException{
            PessoaTO pessoa =
                    pessoaRepository
                            .findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + id));

        return ResponseEntity.ok().body(pessoa);
    }

    @PutMapping("/Pessoa/{id}")
    public String atualizarPessoa(@RequestBody PessoaTO pessoaTO)
        throws ResourceNotFoundException{
            PessoaTO pessoa =
                    pessoaRepository
                            .findById(pessoaTO.getId())
                            .orElseThrow(() -> new ResourceNotFoundException("Não existe pessoa com o ID: " + pessoaTO.getId()));
            pessoaRepository.save(pessoaTO);

        return "Sucesso ao atualizar";
    }

    @GetMapping("/PessoaNome/{nome}")
    public ResponseEntity<PessoaTO> listarPessoaPeloNome(@PathVariable(name = "nome") String nome) throws ResourceNotFoundException{
        PessoaTO pessoa =
                pessoaRepository
                        .findByNome(nome)
                        .orElseThrow(() -> new ResourceNotFoundException("Pessoa com o nome " + nome + " não encontrada!"));
        return ResponseEntity.ok().body(pessoa);
    }
}
