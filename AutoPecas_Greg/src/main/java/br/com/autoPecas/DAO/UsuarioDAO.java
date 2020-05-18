package br.com.autoPecas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.autoPecas.connection.ConnectionBase;
import br.com.autoPecas.entity.Usuario;

public class UsuarioDAO {

	public void cadastrarUsuario(Usuario usuario) throws SQLException {

		Connection conexao = null;
		PreparedStatement pst = null;

		try {
			conexao = ConnectionBase.getConnection();
			conexao.setAutoCommit(false);

			pst = conexao.prepareStatement("INSERT INTO usuario(nome,email,senha) VALUES(?,?,?)");

			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
			conexao.rollback();
		} finally {
			conexao.commit();
			pst.close();
			conexao.close();
		}

	}

	public List<Usuario> listar() {
		List<Usuario> lista = new ArrayList<Usuario>();

		try {
			Connection conexao = ConnectionBase.getConnection();
			Statement stm = conexao.createStatement();

			String sql = "SELECT * FROM usuario";
			ResultSet resultSet = stm.executeQuery(sql);

			while (resultSet.next()) {
				String nome = resultSet.getString("nome");
				String email = resultSet.getString("email");
				String senha = resultSet.getString("senha");

				Usuario novo = new Usuario();
				novo.setNome(nome);
				novo.setEmail(email);
				novo.setSenha(senha);
				lista.add(novo);
			}

		} catch (Exception e) {
			return null;
		}

		return lista;

	}

}
