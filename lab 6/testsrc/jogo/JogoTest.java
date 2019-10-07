/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package jogo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JogoTest {
	private Jogo tekken;
	private String nome = "Tekken";
	private double preco = 150.0;
	
	@Before
	public void setup() throws Exception{
		this.tekken = new Luta("Tekken", 150.0);
	}
	
	@Test
	public void testGetTitulo(){
		Assert.assertEquals(nome, tekken.getNome());
	}
	
	@Test
	public void testGetPreco(){
		Assert.assertEquals(preco, tekken.getPreco(), 0.00001);
	}
	
	@Test
	public void testGetHighScore() throws Exception {
		tekken.registraJogada(3000, true);
		Assert.assertEquals(3000, tekken.getHighScore());
	}
	
	@Test
	public void testGetJogadas() throws Exception {
		tekken.registraJogada(10, true);
		Assert.assertEquals(1, tekken.getJogadas());
	}
	
	@Test
	public void testGetJogadasZeradas() throws Exception {
		tekken.registraJogada(100, true);
		tekken.registraJogada(20, true);
		Assert.assertEquals(2, tekken.getJogadasZeradas());
	}
	
	// Testes com Exception
	
	@Test(expected = Exception.class)
	public void testNomeVazio() throws Exception{
		tekken = new Luta("", 150.0);
	}
	
	@Test(expected = Exception.class)
	public void testNomeNulo() throws Exception{
		tekken = new Luta(null, 150.0);
	}
	
	@Test(expected = Exception.class)
	public void testPrecoZero() throws Exception{
		tekken = new Luta("Tekken", 0.0);
	}
	
	@Test(expected = Exception.class)
	public void testPrecoNegativo() throws Exception{
		tekken = new Luta("Tekken", -150.0);
	}
	
	@Test(expected = Exception.class)
	public void testSetNomeVazio() throws Exception{
		tekken.setNome("");
	}
	
	@Test(expected = Exception.class)
	public void testSetNomeNulo() throws Exception{
		tekken.setNome(null);
	}
	
	@Test(expected = Exception.class)
	public void testSetPrecoNegativo() throws Exception{
		tekken.setPreco(-50.0);
	}
	
	@Test(expected = Exception.class)
	public void testSetJogadas() throws Exception{
		tekken.registraJogada(1000, true);
		tekken.setJogadas(0);
	}
	
	@Test(expected = Exception.class)
	public void testSetJogadasZeradas() throws Exception{
		tekken.registraJogada(1000, true);
		tekken.setJogadasZeradas(0);
	}
	
	@Test(expected = Exception.class)
	public void testRegistraJogadas() throws Exception{
		tekken.registraJogada(-50, false);
	}
	
	// Equals e toString
	
	@Test
	public void testEquals() throws Exception {
		Jogo tekken2 = new Luta("Tekken", 150.0);
		Jogo tekken3 = new Luta("Tekken", 5.0);
		Jogo tekken4 = new Luta("Tekken 5", 150.0);
		Assert.assertEquals(tekken, tekken2);
		Assert.assertEquals(tekken, tekken3);
		Assert.assertNotEquals(tekken, tekken4);		
	}
	
	@Test
	public void testToString() throws Exception {
		Jogo sonic = new Plataforma("Sonic", 200.0);
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = "+ Sonic - Plataforma:" + FIM_DE_LINHA;
		toString = toString + "==> Jogou 0 vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Zerou 0 vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Maior score: 0" + FIM_DE_LINHA;
		Assert.assertEquals(sonic.toString(), toString);
	}

}
