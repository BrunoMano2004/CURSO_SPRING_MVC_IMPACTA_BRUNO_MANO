package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.UsuarioTO;

public class DAOUsuario {
	
	public boolean salvarUsuario(UsuarioTO usuario) {
		ConnectionFactory fabricaConexao = new ConnectionFactory();
		
		Connection con = fabricaConexao.criarConexaoDb_usuarios();
		PreparedStatement ps = null;

		boolean salvamento = false;

		try {
			
			ps = con.prepareStatement("INSERT INTO Pessoa (nome, endereco) VALUES (?, ?)");

			ps.setString(1, usuario.getNome().toUpperCase());
			ps.setString(2, usuario.getEndereco().toUpperCase());
			ps.execute();

			salvamento = true;
			System.out.println("Usuario Cadastrado com sucesso");

			

		} catch (Exception mensagemErro) {
			System.out.println(mensagemErro);
			System.out.println("Erro ao salvar!");
			salvamento = false;

		} finally { 

			try {

				if (con != null) {
					con.close();
				}

				if (ps != null) {
					ps.close();
				}

			} catch (Exception msgErro) {
				System.out.println(msgErro);
				System.out.println("Erro ao tentar fechar a conexao");
			}

		}

		return salvamento;
	}
}
