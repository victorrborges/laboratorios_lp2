/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

/** Essa classe representa o objeto Plataforma(Jogo).
 * @author Victor Borges
 */
public class Plataforma extends Jogo {
	public final static int MAXIMUM_SCORE = 100000;
	public final static int TAXA_X2P = 20;
	
	/** Construtor do objeto Plataforma(Jogo) sem jogabilidades.
     */	
	public Plataforma(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco);
	}

	/** Construtor do objeto Plataforma(Jogo) com jogabilidades.
     */	
	public Plataforma(String nome, double preco, Set<Jogabilidade> jogabilidades) throws StringInvalidaException, PrecoInvalidoException {
		super(nome, preco, jogabilidades);
	}
	
	/** Metodo para registrar uma jogada em um Jogo de Plataforma.
     *   @return int - X2P obtido*/
	@Override
	public int registraJogada(int score, boolean venceu) {
		setVezesJogadas(getVezesJogadas() + 1);
		if (score > this.getMaiorScore()) {
			setMaiorScore(score);
		} else if (score > MAXIMUM_SCORE) {
			setMaiorScore(MAXIMUM_SCORE);
		}
		if (venceu) {
			setVezesConcluidas(getVezesConcluidas() + 1);
			return TAXA_X2P;
		}
		return 0;
	}

	/** Metodo que retorna a representacao em string do objeto Plataforma(Jogo).
	 * 	 @return String - Representacao em String de Plataforma(Jogo)*/
	public String toString() {
		String resultado = getNome() + " - Plataforma:" + FIM_DE_LINHA;
		resultado += super.toString();
		return resultado;
	}

}
