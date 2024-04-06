package cadastroAnimais.cadastroAnimais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cadastroAnimais.cadastroAnimais.model.Animal;
import cadastroAnimais.cadastroAnimais.repository.AnimalRepository;

@Controller
public class AnimalController {
	
	@Autowired//Instancia o objeto smepre que ele é chamado
	AnimalRepository animalRepository;
	
	@GetMapping("/animalForm")
	public String animalFormulario() {
		
		return "cadastroAnimal";
	}
	
	@PostMapping("/animalForm")
	public String animalFormularioPost(Animal animal) {
		animalRepository.save(animal);
		
		return "cadastroAnimal";
	}
}
