package br.com.estudo.java.oo;

public class Funcionario extends Pessoa{
	private String cpf;
	private String rg;
	private String cargo;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", rg=" + rg + ", cargo=" + cargo
				+ ", getNome()=" + getNome() + ", getCidade()=" + getCidade()
				+ "]";
	}
}
