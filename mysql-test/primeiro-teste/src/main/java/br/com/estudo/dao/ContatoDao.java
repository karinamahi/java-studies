package br.com.estudo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.estudo.db.ConnectionFactory;
import br.com.estudo.model.Contato;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.StringUtils;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos" + "(nome, email, endereco,dataNascimento)"
				+ "values (?,?,?,?)";

		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			//stmt.(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//stmt.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setTimestamp(4, new Timestamp(new Date().getTime()));
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

	private List<Contato> convertResultSet2ContatoList(ResultSet results) {
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

	private Contato convertResultSet2Contato(ResultSet result) {
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

	public boolean isEmptyOrWhiteSpacesOrNull(String entrada) {
		boolean isEmptyOrWhiteSpaces = StringUtils
				.isEmptyOrWhitespaceOnly(entrada);

		if (isEmptyOrWhiteSpaces == true || entrada == null) {
			return true;
		}
		return false;
	}

	private List<Contato> executaConsulta(PreparedStatement preparedStatement) {
		List<Contato> consulta = null;
		try {
			ResultSet rs = preparedStatement.executeQuery();
			consulta = convertResultSet2ContatoList(rs);

			rs.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return consulta;
	}

	public List<Contato> getContatoByEmail(String email) {
		boolean isEmptyOrWhiteSpacesOrNull = isEmptyOrWhiteSpacesOrNull(email);
		if (isEmptyOrWhiteSpacesOrNull == true) {
			throw new IllegalArgumentException(
					"O email não pode ser nulo ou vazio");
		}
		PreparedStatement preparedStatement;
		List<Contato> consultaEmail = null;
		try {
			preparedStatement = (PreparedStatement) this.connection
					.prepareStatement("select * from contatos where email like ?");
			preparedStatement.setString(1, "%" + email + "%");
			consultaEmail = executaConsulta(preparedStatement);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return consultaEmail;
	}

	public List<Contato> getContatoComNomeIniciandoCom(String inicioNome) {
		boolean isEmptyOrWhiteSpacesOrNull = isEmptyOrWhiteSpacesOrNull(inicioNome);
		if(isEmptyOrWhiteSpacesOrNull==true){			
			throw new IllegalArgumentException("O inicioNome não pode ser nulo ou vazio");
		}
		List<Contato> consultaPrimeiraLetra = null;
		try {
			PreparedStatement preparedStatement;
			preparedStatement =(PreparedStatement) this.connection.prepareStatement("select * from contatos where nome like ?");
			preparedStatement.setString(1, inicioNome + "%");
			consultaPrimeiraLetra = executaConsulta(preparedStatement);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		return consultaPrimeiraLetra;
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
