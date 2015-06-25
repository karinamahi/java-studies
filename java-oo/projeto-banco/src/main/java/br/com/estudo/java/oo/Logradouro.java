package br.com.estudo.java.oo;

public class Logradouro {
	private String rua;
	private String cep;
	private String bairro;
	private Cidade cidade;
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua.toUpperCase();
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro.toUpperCase();
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
}
