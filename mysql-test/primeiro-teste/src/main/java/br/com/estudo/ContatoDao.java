package br.com.estudo;

import java.sql.Connection;
import java.sql.SQLException;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){		
		String sql = "insert into contatos" + "(nome, email, endereco)" + "values (?,?,?)";
		
		try{
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		//stmt.setDate(4, new Date(contato.getDataNascimento().getTimesInMillis()));
	
		stmt.execute();
		stmt.close();
	
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//System.out.println("Gravado.");
		//con.close();

	}
}
