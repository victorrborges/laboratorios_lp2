/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package loja;

import usuario.FactoryUsuario;
import java.util.ArrayList;

import exceptions.BuscaException;
import exceptions.StringInvalidaException;
import exceptions.TipoInvalidoException;
import exceptions.ValorInvalidoException;
import jogo.FactoryJogo;
import usuario.Usuario;

/** Essa classe representa o objeto Loja.
 * @author Victor Borges
 */
public class Loja {
	private FactoryUsuario factoryUsuario = new FactoryUsuario();
	private FactoryJogo factoryJogo = new FactoryJogo();
	private ArrayList<Usuario> usuarios; 
	
	/** Construtor do objeto Loja.
     */	
	public Loja(){
		this.usuarios = new ArrayList<Usuario>();
	}
	
	/** Metodo para retorno da lista de usuarios.
     *   @return ArrayList<Usuario> - Usuarios cadastrados*/
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/** Metodo para definicao dos usuarios.
     */
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	/** Metodo para adicionar um usuario a loja.
     *   @return boolean - Adicao de usuario*/
	public boolean addUsuario(String nome, String user, double dinheiro, String tipo) throws StringInvalidaException, ValorInvalidoException, Exception {
		try{
			return this.usuarios.add(factoryUsuario.criarUsuario(nome, user, dinheiro, tipo));
		} catch (Exception excecao) {
			throw new Exception(excecao);
		}
	}
	
	/** Metodo para adicionar dinheiro a um usuario da loja.
     *   @return boolean - Adicao de dinheiro a um Usuario*/
	public boolean addDinheiro(String user, double quantia) throws StringInvalidaException, ValorInvalidoException, Exception {
		try{
			for (Usuario usuario : usuarios){
				if (usuario.getUser().equals(user)){
					usuario.addDinheiro(quantia);
					return true;
				}
			}
			return false;
		} catch (Exception excecao) {
			throw new Exception(excecao);
		}
	}
	
	/** Metodo para vender um jogo a um usuario.
     *   @return boolean - Venda de Jogo*/
	public boolean vendaJogo(String user, String nome, double preco, String tipo) throws StringInvalidaException, ValorInvalidoException, Exception {
		try{
			for (Usuario usuario : usuarios){
				if (usuario.getUser().equals(user)){
					return usuario.compraJogo(factoryJogo.criarJogo(nome, preco, tipo));
				}
			}
			return false;			
		} catch (Exception excecao){
			throw new Exception(excecao);
		}
	}
	
	/** Metodo para fazer upgrade de usuario.
     *   @return boolean - Upgrade de Usuario*/
	public boolean upgrade(String user) throws StringInvalidaException, ValorInvalidoException, TipoInvalidoException, BuscaException, Exception {
		try{
			Usuario userParaUpgrade = null;
			for (Usuario usuario : usuarios){
				if (usuario.getUser().equals(user)){
					userParaUpgrade = usuario;
				}
			}
			
			if (userParaUpgrade == null){
				throw new BuscaException ("Usuario nao encontrado");
			}
			if (userParaUpgrade.getClass().getSimpleName().equals("Veterano")){
				throw new TipoInvalidoException ("Usuario ja eh veterano");
			}
			if (userParaUpgrade.getX2p() < 1000){
				throw new ValorInvalidoException ("Usuario nao possui X2P suficiente");
			}
			
			Usuario userVeterano = factoryUsuario.criarUsuario(userParaUpgrade.getNome(), user, userParaUpgrade.getDinheiro(), "Veterano");
			this.usuarios.remove(userParaUpgrade);
			return this.usuarios.add(userVeterano);			
		} catch (Exception excecao) {
			throw new Exception(excecao);
		}
	}

	/** Metodo HashCode.
	 * 	 @return int - HashCode*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		return result;
	}

	/** Metodo que retorna a igualdade entre um objeto e uma Loja.
	 * 	 @return boolean - Igualdade entre Loja*/
	public boolean equals(Object objeto) {
		if (objeto instanceof Loja){
			Loja outraLoja = (Loja) objeto;
			if (outraLoja.getUsuarios().equals(this.getUsuarios())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/** Metodo que retorna a representacao em string do objeto Loja.
	 * 	 @return String - Representacao em String de Loja*/
	public String toString(){
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = "=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		for (Usuario usuario : usuarios){
			toString = toString + usuario.toString() + FIM_DE_LINHA;
		}
		toString = toString + FIM_DE_LINHA + "--------------------------------------------" + FIM_DE_LINHA;
		return toString;
	}
}
