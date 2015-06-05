package br.com.estudo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.estudo.dao.ContatoDao;
import br.com.estudo.model.Contato;

public class ContatoDaoTest {
	private ContatoDao dao = null;

	@Before
	public void init() {
		dao = new ContatoDao();
	}

	@Test
	public void deveAdicionarUmContato() {
		Contato contato = new Contato();
		contato.setNome("Teste1");
		contato.setEmail("teste@teste");
		contato.setEndereco("Rua Teste 12");
		dao.adiciona(contato);
	}

	@Test
	public void deveRetornarTodosOsContatos() {
		List<Contato> contatos = dao.getLista();

		Assert.assertNotNull(contatos);
		Assert.assertTrue(contatos.size() > 0);
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco() + "\n");
		}
	}

	@Test
	public void deveAlterarUmContato() {
		Contato contato = new Contato();
		contato.setNome("Sansa Stark");
		contato.setEmail("fulana@test");
		contato.setEndereco("Rua da Fulana");
		contato.setId((long) 7);
		dao.altera(contato);
	}

	@Test
	public void deveExcluirUmContato() {
		Contato contato = new Contato();
		contato.setId((long) 9);
		dao.remove(contato);
	}

	@Test
	public void deveRetornarContatosComALetraInformada() {

		List<Contato> contatos = dao.getContatoComNomeIniciandoCom("T");

		Assert.assertNotNull(contatos);
		Assert.assertTrue(contatos.size() > 0);
		for (Contato contato : contatos) {
			System.out.println("Consulta pelo início do nome");
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco() + "\n");
		}
	}

	@Test
	public void deveRetornarContatoReferenteAoIdInformado() {
		Contato contato = dao.consultaContatoById(15);

		Assert.assertNotNull(contato);
		Assert.assertNotNull(contato.getId());
		Assert.assertTrue(15l == contato.getId());
	}

	@Test
	public void deveRetornarContatosComEmail() {
		List<Contato> contatos = dao.getContatoByEmail("maria");

		Assert.assertNotNull(contatos);
	}

	@Test
	public void deveLancarExceptionQuandoEmailIsEmptyWhiteSpacesOrNull() {
		try {
			dao.getContatoByEmail("   ");
			Assert.fail();
		} catch (IllegalArgumentException exception) {
			Assert.assertEquals(exception.getMessage(),
					"O email não pode ser nulo ou vazio");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExceptionQuandoEmailIsEmptyWhiteSpacesOrNullComAnnotation() {
		dao.getContatoByEmail("");
		Assert.fail();
	}

	@Test
	public void deveLancarExceptionQuandoInicioNomeIsEmptyOrWhiteSpacesOrNull() { // testa se uma
																// excessão é
																// lançada
																// quando o
																// parâmetro
																// passado é
																// nulo, vazio ou contém somente espaços em branco
		try {
			dao.getContatoComNomeIniciandoCom("  ");
			Assert.fail();
		} catch (IllegalArgumentException exception) {
			Assert.assertEquals(exception.getMessage(),
					"O inicioNome não pode ser nulo ou vazio");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExceptionQuandoInicioNomeIsEmptyWhiteSpacesOrNullComAnnotation() {
		dao.getContatoComNomeIniciandoCom(null);
		Assert.fail();
	}
	
}
