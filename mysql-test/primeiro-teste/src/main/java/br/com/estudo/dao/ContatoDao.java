package br.com.estudo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.estudo.db.ConnectionFactory;
import br.com.estudo.model.Contato;

import com.mysql.jdbc.PreparedStatement;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos" + "(nome, email, endereco)"
				+ "values (?,?,?)";

		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			// stmt.setDate(4, new
			// Date(contato.getDataNascimento().getTimesInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		// System.out.println("Gravado.");
		// con.close();
	}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando objeto Contato
				Contato contato = convertResultSet2Contato(rs);
				
				// adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Contato contato) {
		String sql = "update contatos set nome=?,email=?,"
				+ "endereco=? where id=?";

		try {
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			// stmt.setDate(4, new
			// Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(4, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private List<Contato> convertResultSet2ContatoList(ResultSet results){
		List<Contato> contatos = new ArrayList<Contato>();
		try {
			while (results.next()) {
				Contato contato = convertResultSet2Contato(results);
				contatos.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contatos;
	}
	
	private Contato convertResultSet2Contato(ResultSet result){
		try {
			Contato contato = new Contato();
			contato.setId(result.getLong("id"));
			contato.setNome(result.getString("nome"));
			contato.setEmail(result.getString("email"));
			contato.setEndereco(result.getString("endereco"));
			// montando a data através do Calendar
			/*
			 * Calendar data = Calendar.getInstance();
			 * data.setTime(rs.getDate("dataNascimento"));
			 * contato.setDataNascimento(data);
			 */
			return contato;
		} catch (SQLException e) {
			System.out.println("Erro");
			e.printStackTrace();
		}
		return null;
	}

	public List<Contato> getContatoByEmail(String email) {
		if(email==null){
			throw new IllegalArgumentException("O email não pode ser nulo");
		}
		List<Contato> consultaEmail = null;
		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from contatos where email like ?");
			stmt.setString(1, "%" + email + "%");
			ResultSet rs = stmt.executeQuery();
			consultaEmail = convertResultSet2ContatoList(rs);
			
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return consultaEmail;
	}

	public List<Contato> getContatoComNomeIniciandoCom(String inicioNome) {
		if(inicioNome==null){
			throw new IllegalArgumentException("O inicioNome não pode ser nulo");
		}
		try {
			List<Contato> consultaPrimeiraLetra = null;
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from contatos where nome like ?");
			stmt.setString(1, inicioNome + "%");
			ResultSet rs = stmt.executeQuery();
			consultaPrimeiraLetra = convertResultSet2ContatoList(rs);
			
			rs.close();
			stmt.close();
			return consultaPrimeiraLetra;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Contato consultaContatoById(long id) {
		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from contatos where id=?");

			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			Contato contato = null;

			rs.next();
			// Criando objeto Contato
			contato = convertResultSet2Contato(rs);

			System.out.println(contato);
			
			rs.close();
			stmt.close();
			return contato;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}
