package br.com.autoPecas.DAOTEST;

import java.sql.SQLException;

import org.junit.Test;

import br.com.autoPecas.DAO.PecasDAO;
import br.com.autoPecas.entity.PecasDoCarro;

public class PecasDAOTEST {

	@Test
	public void salvarTest() throws SQLException {

		PecasDoCarro pecas = new PecasDoCarro();
		pecas.setCpf("1234567");
		pecas.setNomePeca("teto solar");
		
		PecasDAO pecasDAO = new PecasDAO();
		pecasDAO.cadastrarPecas(pecas);
	}
}
