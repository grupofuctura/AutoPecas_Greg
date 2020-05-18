package br.com.autoPecas.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PecasDoCarro implements Serializable, List<PecasDoCarro> {
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String nomePeca;
	private CarroCadastrado carros;

	public CarroCadastrado getCarros() {
		return carros;
	}

	public void setCarros(CarroCadastrado carros) {
		this.carros = carros;
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		PecasDoCarro other = (PecasDoCarro) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PecasDoCarro [cpf=" + cpf + ", nomePeca=" + nomePeca + ", carros=" + carros + ", getCarros()="
				+ getCarros() + ", getNomePeca()=" + getNomePeca() + ", getCpf()=" + getCpf() + ", hashCode()="
				+ hashCode() + ", size()=" + size() + ", isEmpty()=" + isEmpty() + ", iterator()=" + iterator()
				+ ", toArray()=" + Arrays.toString(toArray()) + ", listIterator()=" + listIterator() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<PecasDoCarro> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(PecasDoCarro e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends PecasDoCarro> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends PecasDoCarro> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public PecasDoCarro get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PecasDoCarro set(int index, PecasDoCarro element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, PecasDoCarro element) {
		// TODO Auto-generated method stub

	}

	@Override
	public PecasDoCarro remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<PecasDoCarro> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<PecasDoCarro> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PecasDoCarro> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
