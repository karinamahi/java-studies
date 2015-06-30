package br.com.estudo.java.oo;

public class Cidade {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	@Override
	public String toString() {
		return "Cidade [nome=" + nome + "]";
	}
	
	
}
