package br.com.javastudies.commonslang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class CommonsLangLearningTest {

	@Test
	public void isEmptyTest(){
		boolean isEmpty = StringUtils.isEmpty("oi");
		Assert.assertFalse(isEmpty);
		
		String texto = "abc";
		
		//verifica se a variável é vazia sem usar a classe StringUtils
		if(texto!=null && !texto.equalsIgnoreCase("")){
			System.out.println("A string não é vazia.");
		}
		
		/*verifica se a variável é vazia utilizando a classe StringUtils
		ou seja, faz a mesma verificação que o if acima, contudo, de uma forma mais simples*/
		if(StringUtils.isNotEmpty(texto)){
			System.out.println("A string não é vazia.");
		}
	}
	
	@Test
	public void trimTest(){
		String texto = "     O método trim remove os espaços em branco à esquerda e à direita      ";
		String trimTexto = StringUtils.trim(texto);
		Assert.assertEquals(trimTexto, "O método trim remove os espaços em branco à esquerda e à direita");
	}
	
	@Test
	public void equalsTest(){
		boolean isEquals = StringUtils.equals("abc", "abc");
		Assert.assertTrue(isEquals);
		
		boolean isEquals1 = StringUtils.equals("abc", "bac");
		Assert.assertFalse(isEquals1);
	}
}
