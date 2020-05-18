package br.com.autoPecas.DAOTEST;

import java.sql.SQLException;


import org.junit.Test;

import br.com.autoPecas.DAO.CarrosDAO;
import br.com.autoPecas.DAO.PecasDAO;
import br.com.autoPecas.entity.CarroCadastrado;
import br.com.autoPecas.entity.PecasDoCarro;

public class CarrosDAOTEST {



	@Test
	public void salvarTest() throws SQLException {
		
		PecasDoCarro novasPecas = new PecasDoCarro();		
		novasPecas.setNomePeca("pneu");
		
		PecasDAO pecasDAO = new PecasDAO();
		pecasDAO.cadastrarPecas(novasPecas);
		
		
		CarroCadastrado novoCarro = new CarroCadastrado();
		novoCarro.setAno(1969);
		novoCarro.setMarca("Ford");
		novoCarro.setModelo("Mustang");
		novoCarro.setPlaca("flk-6666");
		novoCarro.setPecas(novasPecas);
		
		CarrosDAO carrosDAO = new CarrosDAO();
		carrosDAO.cadastrarCarro(novoCarro);
		
		
		
	}
}
