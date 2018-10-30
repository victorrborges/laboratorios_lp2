/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

/** Essa classe representa o objeto Luta(Jogo).
 * @author Victor Borges
 */
public class Luta extends Jogo{

	/** Construtor do objeto Luta(Jogo) sem jogabilidades.
     */	
	public Luta(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
	}
	
	/** Construtor do objeto Luta(Jogo) com jogabilidades.
     */	
	public Luta (String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
	}
	
	/** Metodo para registrar uma jogada em um Jogo de Luta.
     *   @return int - X2P obtido*/
	@Override
	public int registraJogada(int score, boolean venceu) {
		setVezesJogadas(getVezesJogadas()+ 1);
		if(score > this.getMaiorScore()){
			setMaiorScore(score);
		}
		if(venceu){
			setVezesConcluidas(getVezesConcluidas() + 1);
			
		}
		return score/1000;
	}
	
	/** Metodo que retorna a representacao em string do objeto Luta(Jogo).
	 * 	 @return String - Representacao em String de Luta(Jogo)*/
	public String toString() {
		String resultado = getNome() + " - Luta:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}
}
