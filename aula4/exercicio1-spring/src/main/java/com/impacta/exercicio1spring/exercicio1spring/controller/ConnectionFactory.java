package com.impacta.exercicio1spring.exercicio1spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	
private static String SENHA = "bruno2004";
	
	private static String USUARIO = "root";
	
	private static String BANCO_URL_USUARIOS = "jdbc:mysql://localhost:3306/JavaWebSpring?useTimezone=true&serverTimezone=UTC";
	
	public static Connection criarConexaoDb_usuarios() {
		Connection conexao;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexao = DriverManager.getConnection(BANCO_URL_USUARIOS,USUARIO,SENHA);
			System.out.println("Deu certo a conexão!!!");
		
		} catch (Exception mensagemErro) {
			conexao = null;
			System.out.println("Problema ao conectar!!");
			System.out.println("#######################");
			System.out.println(mensagemErro);
			
		}
	
		
		return conexao;
	}
}
