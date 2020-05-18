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
import br.com.autoPecas.connection.ConnectionBase;
import br.com.autoPecas.entity.Automovel;
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

	public List<Cadastro> listarCadastro() {
		List<Cadastro> listar = new ArrayList<>();

		try {
			Connection conexao = ConnectionBase.getConnection();
			Statement st = conexao.createStatement();

			String query = "SELECT * FROM cadastro";
			ResultSet resultSet = st.executeQuery(query);
			CachedRowSet cached = new CachedRowSetImpl();
			cached.populate(resultSet);
			st.close();
			resultSet.close();
			conexao.close();

			while (cached.next()) {
				String nome = cached.getString("nome");
				String email = cached.getString("email");
				Automovel veiculo = (Automovel) cached.getObject("veiculo");

				Cadastro cadastro = new Cadastro();
				cadastro.setEmailCadastro(email);
				cadastro.setNomeCadastro(nome);
				cadastro.setVeiculo(veiculo);

				listar.add(cadastro);
			}
			cached.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listar;
	}

}
