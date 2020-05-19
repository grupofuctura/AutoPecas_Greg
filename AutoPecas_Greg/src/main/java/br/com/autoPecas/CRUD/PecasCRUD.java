package br.com.autoPecas.CRUD;

import java.sql.SQLException;
import java.util.List;

public interface PecasCRUD<Entidade> {

	void cadastrarPecas(Entidade entidade) throws SQLException;

	List<Entidade> listarPecas();
}
