package br.com.estudo.java.oo;

public class Conta {
	private Integer numero;
	private Agencia agencia;
	private Correntista correntista;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public Correntista getCorrentista() {
		return correntista;
	}
	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

}
