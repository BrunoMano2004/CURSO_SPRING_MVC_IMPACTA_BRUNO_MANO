package cadastroMotorista.cadastroMotorista.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping("/listarMotoristas")
	public ModelAndView listarJogadores() {
		ModelAndView motoristaMV = new ModelAndView("listarMotoristas");
		List<MotoristaTO> listaMotoristas = (List<MotoristaTO>)motoristaRepository.findAll();
		motoristaMV.addObject("motoristas", listaMotoristas);
		
		return motoristaMV;
	}
}
