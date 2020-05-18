package br.com.autoPecas.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBase {
	
	public static Connection getConnection() {

		Connection conexao = null;

		try {
			String mysql = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "greg";
			String senha = "12345";

			Class.forName(mysql);

			conexao = DriverManager.getConnection(url, user, senha);
			return conexao;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
