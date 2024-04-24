package apibancodados.apibancodados.controller;

import apibancodados.apibancodados.client.CepClient;
import apibancodados.apibancodados.client.CriptoClient;
import apibancodados.apibancodados.exception.ResourceNotFoundException;
import apibancodados.apibancodados.model.UsuarioTO;
import apibancodados.apibancodados.repository.UsuarioRepository;
import apibancodados.apibancodados.request.SenhaRequestEncript;
import apibancodados.apibancodados.response.CepResponse;
import apibancodados.apibancodados.security.AutClient;
import apibancodados.apibancodados.security.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    AutenticacaoService autenticacaoService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CriptoClient criptoClient;

    @Autowired
    CepClient cepClient;

    CepResponse cepResponse = new CepResponse();

    SenhaRequestEncript senhaRequestEncript = new SenhaRequestEncript();

    @GetMapping("/procurarCpf/{cpf}")
    public ResponseEntity<UsuarioTO> findByCpf(@PathVariable(name = "cpf") long cpf, @RequestHeader String token, @RequestHeader String authorization) throws ResourceNotFoundException {
        autenticacaoService.autenticacaoService(token, authorization);

        UsuarioTO usuario =
                usuarioRepository
                        .findByCpf(cpf)
                        .orElseThrow(() -> new ResourceNotFoundException("CPF não encontrado!"));

        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/cadastrarUsuario")
    public String save(@RequestBody UsuarioTO usuario, @RequestHeader String token, @RequestHeader String authorization){
        autenticacaoService.autenticacaoService(token, authorization);

        cepResponse = cepClient.pegarEndereco(usuario.getCep());
        usuario.setBairro(cepResponse.getBairro());
        usuario.setLogradouro(cepResponse.getLogradouro());

        senhaRequestEncript.setSenhaRequestEncript(usuario.getSenha());
        usuario.setSenha(criptoClient.criptografarSenha(senhaRequestEncript, token, authorization));
        usuarioRepository.save(usuario);

        return "Cadastrado com sucesso!";
    }

    @GetMapping("/listarUsuarios")
    public List<UsuarioTO> buscarUsuarios(@RequestHeader String token, @RequestHeader String authorization){
        autenticacaoService.autenticacaoService(token, authorization);

        return usuarioRepository.findAll();
    }

    @PutMapping("/atualizarUsuarioRota")
    public String atualizarUsuario(@RequestBody UsuarioTO usuario, @RequestHeader String token, @RequestHeader String authorization) throws ResourceNotFoundException{
        autenticacaoService.autenticacaoService(token, authorization);

        if (usuarioRepository.existsByCpf(usuario.getCpf())){

            cepResponse = cepClient.pegarEndereco(usuario.getCep());
            usuario.setBairro(cepResponse.getBairro());
            usuario.setLogradouro(cepResponse.getLogradouro());

            senhaRequestEncript.setSenhaRequestEncript(usuario.getSenha());
            usuario.setSenha(criptoClient.criptografarSenha(senhaRequestEncript, token, authorization));
            usuarioRepository.save(usuario);

            return "Usuario atualizado com sucesso!";
        } else {
            throw new ResourceNotFoundException("Usuario não encontrado! Digite um cpf correto!");
        }
    }
}
