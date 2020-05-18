package br.com.autoPecas.DAOTEST;

import java.sql.SQLException;
import org.junit.Test;
import br.com.autoPecas.DAO.UsuarioDAO;
import br.com.autoPecas.entity.Usuario;
public class UsuarioDAOTEST {

	@Test
	public void salvarTest() throws SQLException {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario novoUsuario = new Usuario();
		novoUsuario.setNome("Gabriel");
		novoUsuario.setEmail("gabriel@hotmail.com");
		novoUsuario.setSenha("12345");

		usuarioDAO.cadastrarUsuario(novoUsuario);
	}

}
