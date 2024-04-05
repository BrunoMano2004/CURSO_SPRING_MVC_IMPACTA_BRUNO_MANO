package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<form action=\"cadastroUsuario\"\" method=\"post\">\r\n"
				+ "		<label>Nome: </label><br/>\r\n"
				+ "		<input type=\"text\"><br/>\r\n"
				+ "		<label>Idade: </label><br/>\r\n"
				+ "		<input type=\"text\"><br/>\r\n"
				+ "		<label>Salario: </label><br/>\r\n"
				+ "		<input type=\"text\"><br/>\r\n"
				+ "		<label>Endereco: </label><br/>\r\n"
				+ "		<input type=\"text\"><br/>\r\n"
				+ "		\r\n"
				+ "		<input type=\"submit\" value=\"Enviar\">\r\n"
				+ "	</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
