package br.com.estudo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContatoDaoTest {
	private ContatoDao dao = null;
	
	@Before
	public void init(){
		dao = new ContatoDao();
	}

	@Test
	public void deveAdicionarUmContato() {
		Contato contato = new Contato();
		contato.setNome("Karina");
		contato.setEmail("teste@teste");
		contato.setEndereco("Rua Teste 12");
		dao.adiciona(contato);
	}
	
	@Test
	public void deveRetornarTodosOsContatos() {
		List<Contato> contatos = dao.getLista();
		
		Assert.assertNotNull(contatos);
		Assert.assertTrue(contatos.size()>0);
		for(Contato contato : contatos){
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " +  contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco() + "\n");
		}
	}
}
