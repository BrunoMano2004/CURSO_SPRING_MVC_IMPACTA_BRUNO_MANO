package cadastroMotorista.cadastroMotorista.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cadastroMotorista.cadastroMotorista.model.MotoristaTO;
import cadastroMotorista.cadastroMotorista.repository.MotoristaRepository;

@Controller
public class MotoristaController {
	
	@Autowired
	MotoristaRepository motoristaRepository;
	
	@GetMapping("/cadastroMotorista")
	public String cadastroMotorista() {
		return "cadastroMotorista";
	}
	
	@PostMapping("/cadastroMotorista")
	public String cadastroMotoristaPost(MotoristaTO obj) {
		
		obj.setSalario(obj.getValorHoraTrabalhada() * obj.getHorasTrabalhadas());
		
		motoristaRepository.save(obj);
		
		return "cadastroMotorista";
	}
}
