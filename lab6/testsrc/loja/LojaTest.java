/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package loja;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuario.*;

public class LojaTest {
	private Loja loja;
	
	@Before
	public void setup() throws Exception {
		this.loja = new Loja();
	}
	
	@Test(expected = Exception.class)
	public void testAddUsuarioNome() throws Exception {
		loja.addUsuario("", "victorrborges", 1000.0, "Veterano");
	}
	
	@Test(expected = Exception.class)
	public void testAddUsuarioUser() throws Exception {
		loja.addUsuario("Victor Borges", "", 1000.0, "Veterano");
	}
	
	@Test(expected = Exception.class)
	public void testAddUsuarioDinheiro() throws Exception {
		loja.addUsuario("Victor Borges", "victorrborges", -1000.0, "Veterano");
	}
	
	@Test
	public void testAddDinheiroUser() throws Exception {
		Assert.assertEquals(false, loja.addDinheiro("naoexisto", 1000));
	}
	
	@Test
	public void testAddDinheiroNegativo() throws Exception {
		Assert.assertEquals(false, loja.addDinheiro("victorrborges", -1000));
	}
	
	@Test
	public void testVendaJogo() throws Exception {
		loja.addUsuario("Victor Borges", "victorrborges", 1000.0, "Veterano");
		Assert.assertEquals(true, loja.vendaJogo("victorrborges", "Tekken", 150.0, "Luta"));
	}
	
	@Test
	public void testUpgrade() throws Exception {
		loja.addUsuario("Victor Borges", "victorrborges", 1000.0, "Noob");
		for (Usuario usuario : loja.getUsuarios()){
			if (usuario.getUser().equals("victorrborges")){
				usuario.setX2p(2000);
			}
		}
		Assert.assertEquals(true, loja.upgrade("victorrborges"));
	}
	
	@Test(expected = Exception.class)
	public void testUpgradeSemUsuario() throws Exception {
		loja.addUsuario("Victor Borges", "victorrborges", 1000.0, "Noob");
		for (Usuario usuario : loja.getUsuarios()){
			if (usuario.getUser().equals("victorrborges")){
				usuario.setX2p(2000);
			}
		}
		loja.upgrade("naoexisto");
	}
	
	@Test(expected = Exception.class)
	public void testUpgradeVeterano() throws Exception {
		loja.addUsuario("Victor Borges", "victorrborges", 1000.0, "Veterano");
		for (Usuario usuario : loja.getUsuarios()){
			if (usuario.getUser().equals("victorrborges")){
				usuario.setX2p(2000);
			}
		}
		loja.upgrade("victorrborges");
	}	
	
	@Test(expected = Exception.class)
	public void testUpgradeSemX2P() throws Exception {
		loja.addUsuario("Victor Borges", "victorrborges", 1000.0, "Veterano");
		loja.upgrade("victorrborges");
	}
	
	//Equals e toString
	
	@Test
	public void testEquals(){
		Loja loja2 = new Loja();
		Assert.assertEquals(loja, loja2);
	}
	
	@Test
	public void testToString() throws Exception {
		loja.addUsuario("Victor Borges", "victorrborges", 1000.0, "Noob");
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = "=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		toString = toString + "victorrborges" + FIM_DE_LINHA;
		toString = toString + "Victor Borges - Jogador Noob" + FIM_DE_LINHA;
		toString = toString + "Lista de Jogos:" + FIM_DE_LINHA;
		toString = toString + FIM_DE_LINHA + "Total de preco dos jogos: RS 0.0" + FIM_DE_LINHA + FIM_DE_LINHA;
		toString = toString + FIM_DE_LINHA + "--------------------------------------------" + FIM_DE_LINHA;
		Assert.assertEquals(toString, loja.toString());
	}
	
}
