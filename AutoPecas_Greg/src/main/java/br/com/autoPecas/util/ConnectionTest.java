package br.com.autoPecas.util;

import java.sql.Connection;

import br.com.autoPecas.connection.ConnectionBase;

public class ConnectionTest {
	
	public static void main(String[] main) {
		
		Connection cb = ConnectionBase.getConnection();
		System.out.println(cb);
		
	}
}
