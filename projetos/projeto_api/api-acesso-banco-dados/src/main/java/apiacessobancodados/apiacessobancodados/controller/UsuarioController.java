package apiacessobancodados.apiacessobancodados.controller;

import apiacessobancodados.apiacessobancodados.exception.ResourceNotFoundException;
import apiacessobancodados.apiacessobancodados.model.UsuarioTO;
import apiacessobancodados.apiacessobancodados.repository.UsuarioRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/cadastroUsuario")
    public String cadastroUsuario(@RequestBody UsuarioTO usuario){
        usuarioRepository.save(usuario);

        return "Usuario cadastrado com sucesso!";
    }

    @GetMapping("/listarUsuarios")
    public List<UsuarioTO> listarUsuarios(){
        List<UsuarioTO> usuarios = usuarioRepository.findAll();

        return usuarios;
    }

    @GetMapping("/listarUsuario/{cpf}")
    public ResponseEntity<UsuarioTO> listarUsuarioPeloCpf(@PathVariable(name = "cpf") long cpf) throws ResourceNotFoundException {
        UsuarioTO usuario =
                usuarioRepository
                        .findByCpf(cpf)
                        .orElseThrow(() -> new ResourceNotFoundException("Usuario com cpf: " + cpf + ", não existe"));

        return ResponseEntity.ok().body(usuario);
    }
}
