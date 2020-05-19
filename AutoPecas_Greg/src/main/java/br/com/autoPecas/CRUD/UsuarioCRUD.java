package br.com.autoPecas.CRUD;

import java.util.List;

public interface UsuarioCRUD<Entidade> {

	void cadastrarUsuario(Entidade entidade);

	List<Entidade> listar();
}
