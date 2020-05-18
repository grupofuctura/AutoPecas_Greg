package br.com.autoPecas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.autoPecas.connection.ConnectionBase;
import br.com.autoPecas.entity.CarroCadastrado;
import br.com.autoPecas.entity.PecasDoCarro;

public class CarrosDAO {

	public void cadastrarCarro(CarroCadastrado carro) throws SQLException {

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
}
