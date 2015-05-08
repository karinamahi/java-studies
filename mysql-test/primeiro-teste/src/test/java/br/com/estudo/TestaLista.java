package br.com.estudo;

import java.util.List;

public class TestaLista {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		
		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " +  contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco() + "\n");
			//System.out.println("Data de nascimento: " + contato.getDataNascimento().getTime() + "\n");
		}

	}

}
