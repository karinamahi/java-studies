package br.com.estudo.db;

import java.sql.Connection;
import java.sql.SQLException;

public class Insere {

	public static void main(String[] args) throws SQLException{
		Connection con = null;
	
		try {
			con = new ConnectionFactory().getConnection();
		
		} finally {
			con.close();
		}
	}
}

