package br.com.autoPecas.CRUD;

import java.sql.SQLException;
import java.util.List;

public interface AutomovelCRUD<Entidade> {

	void cadastrarCarro(Entidade entidade) throws SQLException;

	List<Entidade> listarCarro();

}
