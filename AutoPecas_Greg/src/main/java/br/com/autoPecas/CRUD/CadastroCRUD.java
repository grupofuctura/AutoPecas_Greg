package br.com.autoPecas.CRUD;

import java.sql.SQLException;
import java.util.List;

public interface CadastroCRUD<Entidade> {

	void cadastrar(Entidade entidade) throws SQLException;

	List<Entidade> listarCadastro();
}
