package revisao_api.revisao_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import revisao_api.revisao_api.model.PessoaTO;
import revisao_api.revisao_api.repository.PessoaRepository;

import java.util.List;

@RestController
public class PessoaController {

    @Autowired
    PessoaRepository pr;

    @GetMapping("/listaPessoasRota")
    public List<PessoaTO> listaPessoas(){
        List<PessoaTO> pessoas = (List<PessoaTO>)pr.findAll();

        return pessoas;
    }

    @PostMapping("/cadastroPessoaRota")
    public PessoaTO cadastroPessoa(@RequestBody PessoaTO pessoa){
        pr.save(pessoa);
        return pessoa;
    }
}
