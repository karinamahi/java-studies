package br.com.estudo;

public class TestaInsere {

	public static void main(String[] args) {
		
	
		Contato contato = new Contato();
		contato.setNome("Jofrey");
		contato.setEmail("jofrey@teste.com");
		contato.setEndereco("Rua  Do Sul 123 123");
		//contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado!");

	}

}
