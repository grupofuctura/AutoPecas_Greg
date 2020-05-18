package br.com.autoPecas.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.autoPecas.DAO.CadastroDAO;
import br.com.autoPecas.DAO.CarrosDAO;
import br.com.autoPecas.DAO.PecasDAO;
import br.com.autoPecas.entity.Automovel;
import br.com.autoPecas.entity.Cadastro;
import br.com.autoPecas.entity.PecasDoCarro;
import br.com.autoPecas.util.Faces;

@ManagedBean
@RequestScoped
public class VeiculoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Cadastro cadastro;
	private PecasDoCarro pecas;
	private Automovel carro;
	private CadastroDAO cadastroDAO;
	private CarrosDAO carroDAO;
	private PecasDAO pecasDAO;
	private List<PecasDoCarro> listaDePecas;
	private Faces faces;
	private List<Cadastro> listaCadastro;
	private List<Automovel> listaAutomovel;
	private String cpf;

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

		this.listaDePecas = new ArrayList<>();

		this.faces = new Faces();

	}

	public String cadastrar() throws SQLException {

		if (this.carro.getMarca().isEmpty() || this.carro.getAno() == 0 || this.carro.getModelo().isEmpty()
				|| this.carro.getPlaca().isEmpty() || this.cadastro.getEmailCadastro().isEmpty()
				|| this.cadastro.getNomeCadastro().isEmpty()) {
			this.faces.msgError("preencha todos os campos");
		} else {

			Automovel novoCarro = new Automovel();
			novoCarro.setModelo(this.carro.getModelo());
			novoCarro.setMarca(this.carro.getMarca());
			novoCarro.setAno(this.carro.getAno());
			novoCarro.setPlaca(this.carro.getPlaca());
			novoCarro.setPecas(this.pecas);

			Cadastro novoCadastro = new Cadastro();
			novoCadastro.setEmailCadastro(this.cadastro.getEmailCadastro());
			novoCadastro.setNomeCadastro(this.cadastro.getNomeCadastro());
			novoCadastro.setVeiculo(novoCarro);

			boolean verificarCarro = false;
			boolean verificarCadastro = false;
			for (Automovel auto : this.carroDAO.listarCarro()) {
				if (novoCarro.getPlaca().equals(auto.getPlaca())) {
					verificarCarro = true;
				}
			}

			for (Cadastro cadastro : this.cadastroDAO.listarCadastro()) {
				if (novoCadastro.getEmailCadastro().equals(cadastro.getEmailCadastro())) {
					verificarCadastro = true;
				}
			}

			if (verificarCadastro == true && verificarCarro == true) {
				this.faces.msgError("Você já possui cadastro!");
			} else {

				this.listaAutomovel.add(novoCarro);
				this.listaCadastro.add(novoCadastro);
				return "/pages/terceiraPagina.xhtml";
			}

		}

		return "";
	}

	public void adicionarPecas() {

		PecasDoCarro novasPecas = new PecasDoCarro();
		novasPecas.setCarros(this.carro);
		novasPecas.setNomePeca(this.pecas.getNomePeca());
		this.carro.getPecas().add(novasPecas);
		

	}

	public void salvarCadastro() throws SQLException {
		if (this.pecas.getCpf().isEmpty()) {
			this.faces.msgError("preencha todos os campos!");
		} else {

			boolean verificarPeca = false;
			for (PecasDoCarro pecaCarro : this.pecasDAO.listarPecas()) {
				if (this.cpf.equals(pecaCarro.getCpf())) {
					verificarPeca = true;
				}
			}

			if (verificarPeca) {
				this.faces.msgError("vc já possui cadastro");
			} else {

				this.pecasDAO.cadastrarPecas(this.pecas);
				this.carroDAO.cadastrarCarro(this.carro);
				this.cadastroDAO.cadastrar(this.cadastro);
			}
		}
	}

	public List<PecasDoCarro> getListaDePecas() {
		return listaDePecas;
	}

	public void setListaDePecas(List<PecasDoCarro> listaDePecas) {
		this.listaDePecas = listaDePecas;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
