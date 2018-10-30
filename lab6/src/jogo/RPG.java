/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package jogo;

import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;

/** Essa classe representa o objeto RPG(Jogo).
 * @author Victor Borges
 */
public class RPG extends Jogo {
	
	/** Construtor do objeto RPG(Jogo).
     */	
	public RPG(String nome, double preco) throws StringInvalidaException, ValorInvalidoException {
		super(nome, preco);
	}
	
	/** Metodo para registrar uma jogada em um Jogo de RPG.
     *   @return int - X2P obtido*/
	public int registraJogada(int score, boolean concluido) throws ValorInvalidoException {
		super.registraJogada(score, concluido);
		return 10;
	}
	
	/** Metodo que retorna a representacao em string do objeto RPG(Jogo).
	 * 	 @return String - Representacao em String de RPG(Jogo)*/
	public String toString(){
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = "+ " + this.getNome() + " - RPG:" + FIM_DE_LINHA;
		toString = toString + "==> Jogou " + this.getJogadas() + " vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Zerou " + this.getJogadasZeradas() + " vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Maior score: " + this.getHighScore() + FIM_DE_LINHA;
		return toString;
	}
}
