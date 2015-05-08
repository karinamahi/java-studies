package br.com.estudo;

public class TestaInsere {

	public static void main(String[] args) {
		
	
		Contato contato = new Contato();
		contato.setNome("Teste");
		contato.setEmail("teste@teste.com");
		contato.setEndereco("Rua Teste 123 123");
		//contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado!");

	}

}
