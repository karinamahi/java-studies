package br.com.estudo.java.oo;

public class ProgramaPrincipalImprimeConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setUf("SP");
		
		Cidade cid = new Cidade();
		cid.setNome("Campinas");
		cid.setEstado(estado);
		
		Logradouro logr = new Logradouro();
		logr.setRua("Primeiro Presidente");
		logr.setCep("13090-090");
		logr.setBairro("Jardim dos Presidentes");
		logr.setCidade(cid);
		
		Banco bco = new Banco();
		bco.setCodigo(1111);
		bco.setNome("Banco do Dinheiro");
		
		Agencia ag = new Agencia();
		ag.setCodigo(2222);
		ag.setNome("Agência Leste");
		ag.setLogradouro(logr);
		ag.setBanco(bco);
		ag.setNumero(33);
		
		Correntista corrent = new Correntista();
		corrent.setCodigo(333333);
		corrent.setCpf("11122233344");
		corrent.setNome("Zé");
		
		Conta conta = new Conta();
		conta.setNumero(1);
		conta.setAgencia(ag);
		conta.setCorrentista(corrent);
		
		System.out.println("--- " + conta.getAgencia().getBanco().getNome() + " - " + conta.getAgencia().getBanco().getCodigo() + " ---\n");
		System.out.println("Nº da Conta: " + conta.getNumero() + "\n");
		System.out.println("--- DADOS DA AGENCIA ---");
		System.out.println("Código: " + conta.getAgencia().getCodigo());
		System.out.println("Nome da agência: " + conta.getAgencia().getNome());
		System.out.println("Rua: " + conta.getAgencia().getLogradouro().getRua() + ", nº: " + conta.getAgencia().getNumero());
		System.out.println("Bairro: " +  conta.getAgencia().getLogradouro().getBairro());
		System.out.println("CEP: " +  conta.getAgencia().getLogradouro().getCep());
		System.out.println("Cidade: " + conta.getAgencia().getLogradouro().getCidade().getNome() + " - Estado: " + conta.getAgencia().getLogradouro().getCidade().getEstado().getNome() + " - " + conta.getAgencia().getLogradouro().getCidade().getEstado().getUf() + "\n");
		System.out.println("--- DADOS DO CORRENTISTA ---");
		System.out.println("Código: " + conta.getCorrentista().getCodigo());
		System.out.println("Nome: " + conta.getCorrentista().getNome());
		System.out.println("CPF: " +  conta.getCorrentista().getCpf());
	}

}
