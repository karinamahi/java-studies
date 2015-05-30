package br.com.estudo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data através do Calendar
				/*
				 * Calendar data = Calendar.getInstance();
				 * data.setTime(rs.getDate("dataNascimento"));
				 * contato.setDataNascimento(data);
				 */

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

	public List<Contato> getContatoByEmail(String email) {
		List<Contato> consultaEmail = new ArrayList<Contato>();
		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from contatos where email like ?");
			stmt.setString(1, "%" + email + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				consultaEmail.add(contato);
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return consultaEmail;
	}

	public List<Contato> getContatoComNomeIniciandoCom(String inicioNome) {
		try {
			List<Contato> consultaPrimeiraLetra = new ArrayList<Contato>();
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from contatos where nome like ?");
			stmt.setString(1, inicioNome + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data através do Calendar
				/*
				 * Calendar data = Calendar.getInstance();
				 * data.setTime(rs.getDate("dataNascimento"));
				 * contato.setDataNascimento(data);
				 */

				// adicionando o objeto à lista
				consultaPrimeiraLetra.add(contato);
			}
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

			Contato contato = new Contato();

			rs.next();
			// Criando objeto Contato

			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));

			System.out.println(contato);
			// montando a data através do Calendar
			/*
			 * Calendar data = Calendar.getInstance();
			 * data.setTime(rs.getDate("dataNascimento"));
			 * contato.setDataNascimento(data);
			 */

			rs.close();
			stmt.close();
			return contato;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

}
