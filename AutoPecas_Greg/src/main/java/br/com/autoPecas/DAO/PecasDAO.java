package br.com.autoPecas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

import br.com.autoPecas.CRUD.PecasCRUD;
import br.com.autoPecas.connection.ConnectionBase;
import br.com.autoPecas.entity.PecasDoCarro;

public class PecasDAO implements PecasCRUD<PecasDoCarro> {

//	public Long recuperaId() throws SQLException {
//
//		Long id = null;
//
//		try {
//			Connection conexao = ConnectionBase.getConnection();
//			String query = "select specas.nextval from dual";
//			Statement pstm = conexao.createStatement();
//			ResultSet resultSet = pstm.executeQuery(query);
//			while (resultSet.next()) {
//				id = resultSet.getLong(1);
//			}
//			pstm.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return id;
//
//	}

	public void cadastrarPecas(PecasDoCarro pecas) throws SQLException {
		Connection conexao = null;
		PreparedStatement pst = null;

		try {
			conexao = ConnectionBase.getConnection();
			conexao.setAutoCommit(false);
//			pst = conexao.prepareStatement("INSERT INTO pecas(cpf,nomePeca) VALUE(?,?)");
//			Long id = this.recuperaId();

			String query = "INSERT INTO pecas(cpf,nomePeca) VALUES(?,?)";
			pst = conexao.prepareStatement(query);

			pst.setString(1, pecas.getCpf());
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

	public List<PecasDoCarro> listarPecas() {
		List<PecasDoCarro> listaDePecas = new ArrayList<>();

		try {
			Connection conexao = ConnectionBase.getConnection();
			Statement st = conexao.createStatement();

			String query = "SELECT* FROM pecas";
			ResultSet resultSet = st.executeQuery(query);
			CachedRowSet cached = new CachedRowSetImpl();
			cached.populate(resultSet);
			st.close();
			resultSet.close();
			conexao.close();

			while (cached.next()) {
				String cpf = cached.getString("cpf");
				String nomePeca = cached.getString("nomePeca");

				PecasDoCarro peca = new PecasDoCarro();
				peca.setCpf(cpf);
				peca.setNomePeca(nomePeca);

				listaDePecas.add(peca);
			}
			cached.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaDePecas;

	}
}
