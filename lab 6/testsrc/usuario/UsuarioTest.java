/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import jogo.*;

public class UsuarioTest {
	private Usuario victor;
	private String nome = "Victor Borges";
	private String user = "victorrborges";
	private double dinheiro = 1000.0;
	
	@Before
	public void setup() throws Exception {
		this.victor = new Veterano(nome, user, dinheiro);
	}
	
	@Test
	public void testGetNome(){
		Assert.assertEquals(nome, victor.getNome());
	}
	
	@Test
	public void testGetUser(){
		Assert.assertEquals(user, victor.getUser());
	}
	
	@Test
	public void testGetDinheiro() throws Exception {
		victor.addDinheiro(50.0);
		Assert.assertEquals(1050.0, victor.getDinheiro(), 0.000001);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testGetJogos() throws Exception {
		Jogo tekken = new Luta("Tekken", 150);
		victor.addJogo(tekken);
		@SuppressWarnings("rawtypes")
		HashSet jogosTeste = new HashSet<Jogo>();
		jogosTeste.add(tekken);
		Assert.assertEquals(jogosTeste, victor.getJogos());
	}
	
	@Test
	public void testContemJogo() throws Exception {
		Jogo tekken = new Luta("Tekken", 150);
		victor.addJogo(tekken);
		Assert.assertEquals(true, victor.contemJogo(tekken));
		Assert.assertEquals(true, victor.contemJogo("Tekken"));
	}
	
	@Test
	public void testRegistraJogada() throws Exception {
		Jogo tekken = new Luta("Tekken", 150);
		victor.addJogo(tekken);
		Assert.assertEquals(true, victor.registraJogada("Tekken", 1000, true));
	}
	
	@Test
	public void testGetX2p() throws Exception {
		Jogo tekken = new Luta("Tekken", 150);
		victor.addJogo(tekken);
		victor.registraJogada("Tekken", 1000, true);
		Assert.assertEquals(1001, victor.getX2p());
	}
	
	// Testes com exception
	
	@Test(expected = Exception.class)
	public void testNomeVazio() throws Exception{
		victor = new Noob("", "victorrborges", 200);
	}
	
	@Test(expected = Exception.class)
	public void testNomeNulo() throws Exception{
		victor = new Noob(null, "victorrborges", 200);
	}
	
	@Test(expected = Exception.class)
	public void testUserVazio() throws Exception{
		victor = new Veterano("Victor", "", 200);
	}
	
	@Test(expected = Exception.class)
	public void testUserNulo() throws Exception{
		victor = new Veterano("Victor", null, 200);
	}
	
	@Test(expected = Exception.class)
	public void testDinheiroNegativo() throws Exception{
		victor = new Noob("Victor", "victorrborges", -50.0);
	}
	
	@Test(expected = Exception.class)
	public void testSetNomeVazio() throws Exception{
		victor.setNome("");
	}
	
	@Test(expected = Exception.class)
	public void testSetNomeNulo() throws Exception{
		victor.setNome(null);
	}
	
	@Test(expected = Exception.class)
	public void testSetUserVazio() throws Exception{
		victor.setUser("");
	}
	
	@Test(expected = Exception.class)
	public void testSetUserNulo() throws Exception{
		victor.setNome(null);
	}
	
	@Test(expected = Exception.class)
	public void testSetDinheiroNegativo() throws Exception{
		victor.setDinheiro(-50);
	}
	
	@Test(expected = Exception.class)
	public void testSetX2pMenor() throws Exception{
		victor.setX2p(300);
	}
	
	@Test(expected = Exception.class)
	public void testAddDinheiroNegativo() throws Exception{
		victor.addDinheiro(-50);
	}
	
	@Test(expected = Exception.class)
	public void testCompraJogoNovamente() throws Exception{
		victor = new Noob("Victor Borges", "victorrborges", 400.0);
		Jogo tekken = new Luta("Tekken", 150);
		victor.addJogo(tekken);
		victor.compraJogo(tekken);
	}
	
	@Test(expected = Exception.class)
	public void testCompraJogo() throws Exception {
		victor = new Noob("Victor Borges", "victorrborges", 100.0);
		Jogo tekken = new Luta("Tekken", 150);
		victor.compraJogo(tekken);
	}
	
	// Equals e toString
	
	@Test
	public void testEquals() throws Exception {
		Usuario victor = new Noob("Victor Borges", "victorrborges", 1000);
		Usuario victor2 = new Noob("Victor Eduardo", "victorrborges", 1000);
		Usuario victor3 = new Noob("Victor Borges", "victorborges", 1000);
		Usuario victor4 = new Noob("Victor Borges", "victorrborges", 200);
		Assert.assertEquals(victor, victor2);
		Assert.assertNotEquals(victor, victor3);
		Assert.assertEquals(victor, victor4);		
	}
	
	@Test
	public void testToStringVeterano() throws Exception {
		Jogo sonic = new Plataforma("Sonic", 200.0);
		victor.addJogo(sonic);
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = "victorrborges" + FIM_DE_LINHA;
		toString = toString + "Victor Borges - Jogador Veterano" + FIM_DE_LINHA;
		toString = toString + "Lista de Jogos:" + FIM_DE_LINHA;
		toString = toString + "+ Sonic - Plataforma:" + FIM_DE_LINHA;
		toString = toString + "==> Jogou 0 vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Zerou 0 vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Maior score: 0" + FIM_DE_LINHA + FIM_DE_LINHA;
		toString = toString + FIM_DE_LINHA + "Total de preco dos jogos: RS 200.0" + FIM_DE_LINHA;
		Assert.assertEquals(toString, victor.toString());
	}
	
	@Test
	public void testToStringNoob() throws Exception {
		victor = new Noob("Victor Borges", "victorrborges", 1000.0);
		Jogo sonic = new Plataforma("Sonic", 200.0);
		victor.addJogo(sonic);
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = "victorrborges" + FIM_DE_LINHA;
		toString = toString + "Victor Borges - Jogador Noob" + FIM_DE_LINHA;
		toString = toString + "Lista de Jogos:" + FIM_DE_LINHA;
		toString = toString + "+ Sonic - Plataforma:" + FIM_DE_LINHA;
		toString = toString + "==> Jogou 0 vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Zerou 0 vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Maior score: 0" + FIM_DE_LINHA + FIM_DE_LINHA;
		toString = toString + FIM_DE_LINHA + "Total de preco dos jogos: RS 200.0" + FIM_DE_LINHA;
		Assert.assertEquals(toString, victor.toString());
	}
	
}
