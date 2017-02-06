/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

/** Essa classe representa o objeto RPG(Jogo).
 * @author Victor Borges
 */
public class Rpg extends Jogo{
	public final static int TAXA_X2P = 10;
	
	/** Construtor do objeto RPG(Jogo) sem jogabilidades.
     */	
	public Rpg(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
	}
	
	/** Construtor do objeto RPG(Jogo) com jogabilidades.
     */	
	public Rpg (String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
	}

	/** Metodo para registrar uma jogada em um Jogo de RPG.
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
		return TAXA_X2P;
	}
	
	/** Metodo que retorna a representacao em string do objeto RPG(Jogo).
	 * 	 @return String - Representacao em String de RPG(Jogo)*/
	public String toString() {
		String resultado = getNome() + " - RPG:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}

}
