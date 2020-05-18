package br.com.autoPecas.DAOTEST;

import java.sql.SQLException;

import org.junit.Test;

import br.com.autoPecas.DAO.CadastroDAO;
import br.com.autoPecas.DAO.CarrosDAO;
import br.com.autoPecas.DAO.PecasDAO;
import br.com.autoPecas.entity.Cadastro;
import br.com.autoPecas.entity.Automovel;
import br.com.autoPecas.entity.PecasDoCarro;

public class CadastroDAOTEST {

	@Test
	public void cadastrarTest() throws SQLException {

		PecasDoCarro novasPecas = new PecasDoCarro();
		novasPecas.setCpf("12445");
		novasPecas.setNomePeca("pneu");

		PecasDAO pecasDAO = new PecasDAO();
		pecasDAO.cadastrarPecas(novasPecas);

		Automovel novoCarro = new Automovel();
		novoCarro.setAno(1969);
		novoCarro.setMarca("Ford");
		novoCarro.setModelo("Mustang");
		novoCarro.setPlaca("gtk-4396");
		novoCarro.setPecas(novasPecas);

		CarrosDAO carrosDAO = new CarrosDAO();
		carrosDAO.cadastrarCarro(novoCarro);

		Cadastro novoCadastro = new Cadastro();
		novoCadastro.setNomeCadastro("gabriel");
		novoCadastro.setEmailCadastro("gg3@hotmail.com");
		novoCadastro.setVeiculo(novoCarro);
		CadastroDAO cadastroDAO = new CadastroDAO();
		cadastroDAO.cadastrar(novoCadastro);

	}

}
