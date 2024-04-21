package apibancodados.apibancodados.controller;

import apibancodados.apibancodados.client.CriptoClient;
import apibancodados.apibancodados.exception.ResourceNotFoundException;
import apibancodados.apibancodados.model.UsuarioTO;
import apibancodados.apibancodados.repository.UsuarioRepository;
import apibancodados.apibancodados.request.SenhaRequestEncript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CriptoClient criptoClient;

    SenhaRequestEncript senhaRequestEncript = new SenhaRequestEncript();

    @GetMapping("/procurarCpf/{cpf}")
    public ResponseEntity<UsuarioTO> findByCpf(@PathVariable(name = "cpf") long cpf) throws ResourceNotFoundException {
        UsuarioTO usuario =
                usuarioRepository
                        .findByCpf(cpf)
                        .orElseThrow(() -> new ResourceNotFoundException("CPF não encontrado!"));

        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/cadastrarUsuario")
    public String save(@RequestBody UsuarioTO usuario){

        senhaRequestEncript.setSenhaRequestEncript(usuario.getSenha());
        usuario.setSenha(criptoClient.criptografarSenha(senhaRequestEncript));
        usuarioRepository.save(usuario);

        return "Cadastrado com sucesso!";
    }
}
