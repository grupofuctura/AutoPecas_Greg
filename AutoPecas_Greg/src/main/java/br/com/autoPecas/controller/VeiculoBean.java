package br.com.autoPecas.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.autoPecas.DAO.CadastroDAO;
import br.com.autoPecas.DAO.CarrosDAO;
import br.com.autoPecas.DAO.PecasDAO;
import br.com.autoPecas.entity.Automovel;
import br.com.autoPecas.entity.Cadastro;
import br.com.autoPecas.entity.PecasDoCarro;
import br.com.autoPecas.util.Faces;

public class VeiculoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Cadastro cadastro;
	private PecasDoCarro pecas;
	private Automovel carro;
	private CadastroDAO cadastroDAO;
	private CarrosDAO carroDAO;
	private PecasDAO pecasDAO;
	private Faces faces;
	private List<Cadastro> listaCadastro;
	private List<Automovel> listaAutomovel;

	public VeiculoBean() {
		this.cadastro = new Cadastro();
		this.cadastroDAO = new CadastroDAO();

		this.carro = new Automovel();
		this.carro.setPecas(new ArrayList<PecasDoCarro>());
		this.carroDAO = new CarrosDAO();

		this.pecas = new PecasDoCarro();
		this.pecasDAO = new PecasDAO();

		this.listaCadastro = new ArrayList<>();
		this.listaAutomovel = new ArrayList<>();

		this.faces = new Faces();

	}

	public void salvarEmMemoria() {
		Automovel novoCarro = new Automovel();
		novoCarro.setModelo(this.carro.getModelo());
		novoCarro.setMarca(this.carro.getMarca());
		novoCarro.setAno(this.carro.getAno());
		novoCarro.setPlaca(this.carro.getPlaca());
		novoCarro.setPecas(this.pecas);
		this.listaAutomovel.add(novoCarro);

		Cadastro novoCadastro = new Cadastro();
		novoCadastro.setEmailCadastro(this.cadastro.getEmailCadastro());
		novoCadastro.setNomeCadastro(this.cadastro.getNomeCadastro());
		novoCadastro.setVeiculo(novoCarro);
		this.listaCadastro.add(novoCadastro);
	}
	public void adicionarPecas() {
		PecasDoCarro novasPecas = new PecasDoCarro();
		novasPecas.setCarros(this.carro);
		novasPecas.setCpf(this.pecas.getCpf());
		novasPecas.setNomePeca(this.pecas.getNomePeca());
		this.carro.getPecas().add(novasPecas);

	}
	public void salvarCadastro() throws SQLException {

		this.pecasDAO.cadastrarPecas(this.pecas);
		this.carroDAO.cadastrarCarro(this.carro);
		this.cadastroDAO.cadastrar(this.cadastro);

	}

	public List<Automovel> getListaAutomovel() {
		return listaAutomovel;
	}

	public void setListaAutomovel(List<Automovel> listaAutomovel) {
		this.listaAutomovel = listaAutomovel;
	}

	public List<Cadastro> getListaCadastro() {
		return listaCadastro;
	}

	public void setListaCadastro(List<Cadastro> listaCadastro) {
		this.listaCadastro = listaCadastro;
	}

	public Faces getFaces() {
		return faces;
	}

	public void setFaces(Faces faces) {
		this.faces = faces;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public PecasDoCarro getPecas() {
		return pecas;
	}

	public void setPecas(PecasDoCarro pecas) {
		this.pecas = pecas;
	}

	public Automovel getCarro() {
		return carro;
	}

	public void setCarro(Automovel carro) {
		this.carro = carro;
	}

}
