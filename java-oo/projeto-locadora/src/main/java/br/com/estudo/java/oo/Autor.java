package br.com.estudo.java.oo;

public class Autor {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + "]";
	}
}
