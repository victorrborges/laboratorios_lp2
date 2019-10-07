/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package usuario;

import jogo.Jogo;
import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;
import exceptions.BuscaException;

/** Essa classe representa o objeto Noob(Usuario).
 * @author Victor Borges
 */
public class Noob extends Usuario {
	
	/** Construtor do objeto Noob(Usuario).
     */	
	public Noob(String nome, String user, double dinheiro) throws StringInvalidaException, ValorInvalidoException {
		super(nome, user, dinheiro, 0);
	}

	/** Metodo para um Usuario Noob comprar um Jogo.
     *   @return boolean - Noob(Usuario) compra Jogo*/
	public boolean compraJogo(Jogo jogo) throws StringInvalidaException, ValorInvalidoException, BuscaException {
		boolean comprouJogo = false;
		double precoDescontado = jogo.getPreco() - (jogo.getPreco() * (15/100));		
		
		if (this.contemJogo(jogo)){
			throw new BuscaException ("O usuario ja possui esse jogo");
		}
		if (precoDescontado > this.getDinheiro()){
			throw new ValorInvalidoException("O usuario nao possui dinheiro para adquirir o jogo");
		}
		
		comprouJogo = this.addJogo(jogo);
		
		if (comprouJogo){
			this.setDinheiro(this.getDinheiro() - precoDescontado);
			this.setX2p(this.getX2p() + 15 * (int)jogo.getPreco());
		}
		
		return comprouJogo;
	}
	
	/** Metodo que retorna a representacao em string do objeto Noob(Usuario).
	 * 	 @return String - Representacao em String de Noob(Usuario)*/
	public String toString(){
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = this.getUser() + FIM_DE_LINHA;
		toString = toString + this.getNome() + " - Jogador Noob" + FIM_DE_LINHA;
		toString = toString + "Lista de Jogos:" + FIM_DE_LINHA;
		double precoTotal = 0;
		for (Jogo jogo : this.getJogos()){
			toString = toString + jogo.toString() + FIM_DE_LINHA;
			precoTotal = precoTotal + jogo.getPreco();
		}
		String valor = String.format("%.2f", precoTotal);
		valor = valor.replace(",", ".");
		toString = toString + FIM_DE_LINHA + "Total de preco dos jogos: RS " + precoTotal + FIM_DE_LINHA;
		return toString;
	}
} 