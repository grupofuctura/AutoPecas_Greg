package br.com.autoPecas.entity;

import java.io.Serializable;

public class Cadastro implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nomeCadastro;
	private String emailCadastro;
	private Automovel veiculo;

	public Automovel getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Automovel veiculo) {
		this.veiculo = veiculo;
	}

	public String getNomeCadastro() {
		return nomeCadastro;
	}

	public void setNomeCadastro(String nomeCadastro) {
		this.nomeCadastro = nomeCadastro;
	}

	public String getEmailCadastro() {
		return emailCadastro;
	}

	public void setEmailCadastro(String emailCadastro) {
		this.emailCadastro = emailCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailCadastro == null) ? 0 : emailCadastro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		if (emailCadastro == null) {
			if (other.emailCadastro != null)
				return false;
		} else if (!emailCadastro.equals(other.emailCadastro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cadastro [nomeCadastro=" + nomeCadastro + ", emailCadastro=" + emailCadastro + ", veiculo=" + veiculo
				+ ", getVeiculo()=" + getVeiculo() + ", getNomeCadastro()=" + getNomeCadastro()
				+ ", getEmailCadastro()=" + getEmailCadastro() + ", hashCode()=" + hashCode() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

}
