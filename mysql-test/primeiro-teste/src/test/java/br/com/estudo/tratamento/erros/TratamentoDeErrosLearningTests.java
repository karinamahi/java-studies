package br.com.estudo.tratamento.erros;

public class TratamentoDeErrosLearningTests {
	public void chamandoMetodoQueLancaException(){
		try{
			metodoQueLancaexception();
		}catch(Exception e){
			System.out.println("Deu erro");
			e.printStackTrace();
		}
	}
	
	private void metodoQueLancaexception() throws Exception{
		
	}

}
