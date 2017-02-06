/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package jogo;

import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;

/** Essa classe representa o objeto Plataforma(Jogo).
 * @author Victor Borges
 */
public class Plataforma extends Jogo {
	
	/** Construtor do objeto Plataforma(Jogo).
     */	
	public Plataforma(String nome, double preco) throws StringInvalidaException, ValorInvalidoException {
		super(nome, preco);
	}
	
	/** Metodo para registrar uma jogada em um Jogo de Plataforma.
     *   @return int - X2P obtido*/
	public int registraJogada(int score, boolean concluido) throws ValorInvalidoException {
		int x2p = 0;
		if (concluido){
			x2p = 20;
		}
		super.registraJogada(score, concluido);
		return x2p;
	}
	
	/** Metodo que retorna a representacao em string do objeto Plataforma(Jogo).
	 * 	 @return String - Representacao em String de Plataforma(Jogo)*/
	public String toString(){
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = "+ " + this.getNome() + " - Plataforma:" + FIM_DE_LINHA;
		toString = toString + "==> Jogou " + this.getJogadas() + " vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Zerou " + this.getJogadasZeradas() + " vez(es)" + FIM_DE_LINHA;
		toString = toString + "==> Maior score: " + this.getHighScore() + FIM_DE_LINHA;
		return toString;
	}
}
