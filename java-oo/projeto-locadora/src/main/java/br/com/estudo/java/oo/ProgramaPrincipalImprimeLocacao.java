package br.com.estudo.java.oo;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class ProgramaPrincipalImprimeLocacao 
{
    public static void main( String[] args )
    {
    	   	
        Genero romance = new Genero();
        romance.setDescricao("Romance");
        
        Autor steven = new Autor();
        steven.setNome("Pedro Luiz");
        
        Atendente atend1 = new Atendente();
        atend1.setCpf("111.222.333-45");
        atend1.setNome("Maria");
        
        Cliente cliente1 = new Cliente();
        cliente1.setCpf("222.333.444-56");
        cliente1.setNome("Zé");
        
        Filme histAmor = new Filme();
        histAmor.setNome("Uma história de amor");
        histAmor.setGenero(romance);
        histAmor.setAutor(steven);
        
        Locacao loc1 = new Locacao();
        loc1.setCliente(cliente1);
        loc1.setFilme(histAmor);
        Date dataLoc = new Date();
        dataLoc.setDate(25);
        dataLoc.setMonth(6);
        dataLoc.setYear(115);
        loc1.setDataLocacao(dataLoc);
        Date dataEntr = new Date();
        dataEntr.setDate(27);
        dataEntr.setMonth(6);
        dataEntr.setYear(115);
        loc1.setDataEntrega(dataEntr);
        loc1.setAtendente(atend1);
        
        System.out.println(loc1.getCliente().toString());
        System.out.println(loc1.getFilme().toString());
        System.out.println(loc1.getDataLocacao());
        System.out.println(loc1.getDataEntrega());    
        System.out.println(loc1.getAtendente().toString());
    }
}
