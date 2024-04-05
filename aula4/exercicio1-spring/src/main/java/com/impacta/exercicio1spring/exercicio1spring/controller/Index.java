package com.impacta.exercicio1spring.exercicio1spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {
	
	@GetMapping("/index")
	public String Inicio() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
}
