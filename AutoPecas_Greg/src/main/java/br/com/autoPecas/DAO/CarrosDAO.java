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
import br.com.autoPecas.entity.PecasDoCarro;

public class CarrosDAO {

	public void cadastrarCarro(Automovel carro) throws SQLException {

		Connection conexao = null;
		PreparedStatement pst = null;

		try {
			conexao = ConnectionBase.getConnection();
			conexao.setAutoCommit(false);

			String querry = "INSERT INTO carros(placa,marca,modelo,ano,pecas) VALUES(?,?,?,?,?)";
			pst = conexao.prepareStatement(querry);

			pst.setString(1, carro.getPlaca());
			pst.setString(2, carro.getMarca());
			pst.setString(3, carro.getModelo());
			pst.setInt(4, carro.getAno());
			pst.setString(5, ((PecasDoCarro) carro.getPecas()).getCpf());
			pst.addBatch();
			int[] salvoNoBanco = pst.executeBatch();
			System.out.println(salvoNoBanco);

		} catch (Exception e) {
			e.printStackTrace();
			conexao.rollback();
		} finally {
			conexao.commit();
			pst.close();
			conexao.close();
		}
	}

	public List<Automovel> listarCarro() {

		List<Automovel> listaAutomovel = new ArrayList<>();

		try {
			Connection conexao = ConnectionBase.getConnection();
			Statement st = conexao.createStatement();

			String query = "SELECT * FROM carros";
			ResultSet resultSet = st.executeQuery(query);
			CachedRowSet cached = new CachedRowSetImpl();
			cached.populate(resultSet);

			st.close();
			resultSet.close();
			conexao.close();

			while (cached.next()) {
				String placa = cached.getString("placa");
				String modelo = cached.getString("modelo");
				String marca = cached.getString("marca");
				int ano = cached.getInt("ano");

				Automovel automovel = new Automovel();
//				List<PecasDoCarro> pecas = (List<PecasDoCarro>) cached.getArray("pecas");
//				for (int i = 1; i < pecas.size(); i++) {
//					automovel.setPecas(pecas);
//				}

				automovel.setAno(ano);
				automovel.setMarca(marca);
				automovel.setModelo(modelo);
				automovel.setPlaca(placa);

				listaAutomovel.add(automovel);
			}
			cached.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaAutomovel;
	}
}
