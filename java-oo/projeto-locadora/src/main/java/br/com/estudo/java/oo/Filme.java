package br.com.estudo.java.oo;

public class Filme {
	private String nome;
	private Genero genero;
	private Autor autor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Filme [nome=" + nome + ", genero=" + genero + ", autor="
				+ autor + "]";
	}
}
