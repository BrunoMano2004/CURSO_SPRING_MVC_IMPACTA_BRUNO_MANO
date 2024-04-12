package primeiraAPI.primeiraAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import primeiraAPI.primeiraAPI.model.MeuPrimeiroPost;
import primeiraAPI.primeiraAPI.repository.MeuPrimeiroPostRepository;

@RestController
public class PrimeiraApiController {

    @Autowired
    MeuPrimeiroPostRepository repo;

    @GetMapping("/primeiroGet")
    public String primeiroPost(){
        return "Primeiro método post na API";
    }

    @PostMapping("/primeiroPostRota")
    public String primeiroPost(@RequestBody MeuPrimeiroPost obj){
        repo.save(obj);
        return "O texto enviado foi: " + obj.getMeuTexto();
    }
}
