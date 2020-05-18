package br.com.autoPecas.entity;

import java.io.Serializable;
import java.util.List;

public class CarroCadastrado implements Serializable {
	private static final long serialVersionUID = 1L;

	private String placa;
	private String marca;
	private String modelo;
	private int ano;
	private List<PecasDoCarro> Pecas;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<PecasDoCarro> getPecas() {
		return Pecas;
	}

	public void setPecas(List<PecasDoCarro> pecas) {
		Pecas = pecas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		CarroCadastrado other = (CarroCadastrado) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarroCadastrado [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano
				+ ", Pecas=" + Pecas + "]";
	}
}
