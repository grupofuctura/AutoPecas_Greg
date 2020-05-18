package br.com.autoPecas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.autoPecas.connection.ConnectionBase;
import br.com.autoPecas.entity.Cadastro;

public class CadastroDAO {

	public void cadastrar(Cadastro cadastro) throws SQLException {

		Connection conexao = null;
		PreparedStatement pst = null;

		try {
			conexao = ConnectionBase.getConnection();
			conexao.setAutoCommit(false);

			String query = "INSERT INTO cadastro(nome,email,veiculo) VALUES(?,?,?)";
			pst = conexao.prepareStatement(query);

			pst.setString(1, cadastro.getNomeCadastro());
			pst.setString(2, cadastro.getEmailCadastro());
			pst.setString(3, cadastro.getVeiculo().getPlaca());

			pst.addBatch();
			int[] linhas = pst.executeBatch();
			System.out.println(linhas);
		} catch (Exception e) {
			e.printStackTrace();
			conexao.rollback();
		} finally {
			conexao.commit();
			pst.close();
			conexao.close();
		}

	}

}
