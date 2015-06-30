package br.com.estudo.java.oo;

/**
 * Hello world!
 *
 */
public class ProgramaPrincipalHeranca {
	public static void main(String[] args) {

		Cidade cp = new Cidade();
		cp.setNome("Campinas");

		Cliente cliente = new Cliente();
		cliente.setNome("Zé"); // Pessoa
		cliente.setRg("01010101");
		cliente.setCpf("02020202");
		cliente.setCidade(cp); // Pessoa

		Funcionario func1 = new Funcionario();
		func1.setNome("Maria");
		func1.setCargo("Programadora Java");
		func1.setCidade(cp);
		func1.setCpf("123456");
		func1.setRg("654321");
		
		System.out.println(func1.toString());
	}
}
