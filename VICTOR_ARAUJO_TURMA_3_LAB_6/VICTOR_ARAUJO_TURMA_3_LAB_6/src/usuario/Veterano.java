/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package usuario;

import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;
import exceptions.BuscaException;
import jogo.Jogo;

/** Essa classe representa o objeto Veterano(Usuario).
 * @author Victor Borges
 */
public class Veterano extends Usuario {
	
	/** Construtor do objeto Veterano(Usuario).
     */	
	public Veterano(String nome, String user, double dinheiro) throws StringInvalidaException, ValorInvalidoException {
		super(nome, user, dinheiro, 1000);
	}

	/** Metodo para um Usuario Veterano comprar um Jogo.
     *   @return boolean - Veterano(Usuario) compra Jogo*/
	public boolean compraJogo(Jogo jogo) throws StringInvalidaException, ValorInvalidoException, BuscaException {
		boolean comprouJogo = false;
		double precoDescontado = jogo.getPreco() - (jogo.getPreco() * (20/100));		
		
		if (this.contemJogo(jogo)){
			throw new BuscaException ("O usuario ja possui esse jogo");
		}
		if (precoDescontado > this.getDinheiro()){
			throw new ValorInvalidoException ("O usuario nao possui dinheiro para adquirir o jogo");
		}
		
		comprouJogo = this.addJogo(jogo);
		
		if (comprouJogo){
			this.setDinheiro(this.getDinheiro() - precoDescontado);
			this.setX2p(this.getX2p() + 15 * (int)jogo.getPreco());
		}
		
		return comprouJogo;
	}
	
	/** Metodo que retorna a representacao em string do objeto Veterano(Usuario).
	 * 	 @return String - Representacao em String de Veterano(Usuario)*/
	public String toString(){
		String FIM_DE_LINHA = System.lineSeparator();
		String toString = this.getUser() + FIM_DE_LINHA;
		toString = toString + this.getNome() + " - Jogador Veterano" + FIM_DE_LINHA;
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
