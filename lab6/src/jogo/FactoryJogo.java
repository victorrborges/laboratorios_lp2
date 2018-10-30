/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package jogo;

import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;

/** Essa classe representa o Factory de Jogo.
 * @author Victor Borges
 */
 public class FactoryJogo {
	 
	 /** Metodo para criar um Jogo.
	     *   @return Jogo - Jogo criado*/
	public Jogo criarJogo(String nome, double preco, String tipo) throws StringInvalidaException, ValorInvalidoException {
		Jogo jogo = null;
		if (tipo.equalsIgnoreCase("plataforma")){
			jogo = new Plataforma(nome, preco);
		} else if (tipo.equalsIgnoreCase("luta")){
			jogo = new Luta(nome, preco);
		} else if (tipo.equalsIgnoreCase("rpg")){
			jogo = new RPG(nome, preco);
		}
		return jogo;
	}
}
