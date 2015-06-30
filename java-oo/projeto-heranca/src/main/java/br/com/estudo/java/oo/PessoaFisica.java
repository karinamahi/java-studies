package br.com.estudo.java.oo;

public class PessoaFisica extends Pessoa{

	private String cpf;
	private String rg;

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}
