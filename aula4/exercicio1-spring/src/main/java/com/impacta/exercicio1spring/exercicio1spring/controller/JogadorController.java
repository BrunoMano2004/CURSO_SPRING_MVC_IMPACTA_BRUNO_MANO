package com.impacta.exercicio1spring.exercicio1spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.impacta.exercicio1spring.exercicio1spring.model.JogadorTO;

@Controller
public class JogadorController {
	
	private PreparedStatement ps;
	private Connection con;
	
	@GetMapping("/cadastroJogador")
	public String cadastro() {
		return "cadastroJogador";
	}
	
	@PostMapping("/cadastroJogador")
	public String cadastroJogadorPost(JogadorTO obj) {
		con = ConnectionFactory.criarConexaoDb_usuarios();
		
		try {
			ps = con.prepareStatement("INSERT INTO Jogador (nome, time) VALUES (?, ?)");
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getTime());
			ps.execute();
			System.out.println("Inserido com sucesso!");
			
		}catch(SQLException e) {
			System.out.println("Erro ao inserir!");
			System.out.println(e.getMessage());
		}finally {
			try {
				con.close();
				ps.close();
			}catch(SQLException e) {
				System.out.println("Erro ao fechar a conexão!");
				System.out.println(e.getMessage());
			}
		}
		
		return "index";
	}
}
