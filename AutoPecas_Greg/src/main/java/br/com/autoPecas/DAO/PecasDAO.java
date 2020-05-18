package br.com.autoPecas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.autoPecas.connection.ConnectionBase;
import br.com.autoPecas.entity.PecasDoCarro;

public class PecasDAO {

	public Long recuperaId() throws SQLException {

		Long id = null;

		try {
			Connection conexao = ConnectionBase.getConnection();
			String query = "select specas.nextval from dual";
			Statement pstm = conexao.createStatement();
			ResultSet resultSet = pstm.executeQuery(query);
			while (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			pstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;

	}

	public void cadastrarPecas(PecasDoCarro pecas) throws SQLException {
		Connection conexao = null;
		PreparedStatement pst = null;

		try {
			conexao = ConnectionBase.getConnection();
			conexao.setAutoCommit(false);
			pst = conexao.prepareStatement("INSERT INTO pecas(id_peca,nomePeca) VALUE(?,?)");
			Long id = this.recuperaId();
			
			pst.setLong(1, id);
			pst.setString(2, pecas.getNomePeca());

			pst.execute();
//			int linha = pst.executeUpdate();
//			if (linha >= 1) {
//				ResultSet resultSet = pst.getGeneratedKeys();
//				int id = resultSet.getInt(1);
//				pecas.setId_pecas(id);
//			}

		} catch (SQLException e) {
			e.printStackTrace();
			conexao.rollback();

		}
		conexao.commit();
		pst.close();
		conexao.close();

	}
}
