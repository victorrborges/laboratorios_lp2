/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package jogo;

import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;

/** Essa classe representa o Factory de Jogo.
 * @author Victor Borges
 */
public class FactoryJogo {
	
	/** Metodo para criar um Jogo.
     *   @return Jogo - Jogo criado*/
	public Jogo criaJogo(String nome, double preco,Set<Jogabilidade> jogabilidades, String tipo) throws StringInvalidaException, ValorInvalidoException, PrecoInvalidoException {
		Jogo jogo = null;
		if (tipo.equalsIgnoreCase("plataforma")){
			jogo = new Plataforma(nome, preco, jogabilidades);
		} else if (tipo.equalsIgnoreCase("luta")){
			jogo = new Luta(nome, preco, jogabilidades);
		} else if (tipo.equalsIgnoreCase("rpg")){
			jogo = new Rpg(nome, preco, jogabilidades);
		}
		return jogo;
	}
}