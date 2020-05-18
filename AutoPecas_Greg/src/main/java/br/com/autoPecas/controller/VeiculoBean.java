package br.com.autoPecas.controller;

import java.io.Serializable;

public class VeiculoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String txtNome;
	private String txtEmail;
	private String txtMarca;
	private String txtModelo;
	private int txtAno;
	private String txtPlaca;
	
	
	
	
	
	
	public String getTxtNome() {
		return txtNome;
	}
	public void setTxtNome(String txtNome) {
		this.txtNome = txtNome;
	}
	public String getTxtEmail() {
		return txtEmail;
	}
	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}
	public String getTxtMarca() {
		return txtMarca;
	}
	public void setTxtMarca(String txtMarca) {
		this.txtMarca = txtMarca;
	}
	public String getTxtModelo() {
		return txtModelo;
	}
	public void setTxtModelo(String txtModelo) {
		this.txtModelo = txtModelo;
	}
	public int getTxtAno() {
		return txtAno;
	}
	public void setTxtAno(int txtAno) {
		this.txtAno = txtAno;
	}
	public String getTxtPlaca() {
		return txtPlaca;
	}
	public void setTxtPlaca(String txtPlaca) {
		this.txtPlaca = txtPlaca;
	}
	
	
	
	
	
	
	
	
	

}
