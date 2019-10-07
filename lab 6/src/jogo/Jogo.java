/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package jogo;

import java.util.HashSet;
import enumerations.Jogabilidade;
import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;

/** Essa classe representa o objeto Jogo.
 * @author Victor Borges
 */
public abstract class Jogo {
	private String nome;
	private double preco;
	private int highScore;
	private int jogadas;
	private int jogadasZeradas;
	private HashSet<Jogabilidade> jogabilidade;
	
	/** Construtor do objeto Jogo.
     */	
	public Jogo (String nome, double preco) throws StringInvalidaException, ValorInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException ("O nome do jogo nao pode ser nulo ou vazio");
		}
		if (preco <= 0) {	
			throw new ValorInvalidoException ("O preco do jogo nao pode ser menor ou igual a zero");
		}
		this.nome = nome;
		this.preco = preco;
		this.highScore = 0;
		this.jogadas = 0;
		this.jogadasZeradas = 0;
		this.jogabilidade = new HashSet<Jogabilidade>();
	}

	/** Metodo para retorno do nome do jogo.
     *   @return String - Nome do Jogo*/
	public String getNome() {
		return nome;
	}
	
	/** Metodo para definicao do nome do jogo.
     */
	public void setNome(String nome) throws StringInvalidaException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException ("O nome do jogo nao pode ser nulo ou vazio");
		}
		this.nome = nome;
	}

	/** Metodo para retorno do preco do jogo.
     *   @return double - Preco do Jogo*/
	public double getPreco() {
		return preco;
	}

	// O preco podera ser igual a zero para fins de promocao ou presente em datas comemorativas
	/** Metodo para definicao do preco do jogo.
     */
	public void setPreco(double preco) throws ValorInvalidoException {
		if (preco <= 0) {
			throw new ValorInvalidoException ("O Preco do jogo nao pode ser menor que zero");
		}
		this.preco = preco;
	}

	/** Metodo para retorno do highscore do jogo.
     *   @return int - HighScore do Jogo*/
	public int getHighScore() {
		return highScore;
	}

	/** Metodo para definicao do highscore do jogo.
     */
	public void setHighScore(int highScore) throws ValorInvalidoException {
		if (highScore < this.highScore){
			throw new ValorInvalidoException ("O novo high score nao pode ser menor que o atual");
		}
		this.highScore = highScore;
	}
	
	/** Metodo para retorno da quantidade de jogadas do jogo.
     *   @return int - Jogadas do Jogo*/
	public int getJogadas() {
		return jogadas;
	}

	/** Metodo para definicao do numero de jogadas do jogo.
     */
	public void setJogadas(int jogadas) throws ValorInvalidoException {
		if (jogadas < this.jogadas){
			throw new ValorInvalidoException ("O novo numero de jogadas nao pode ser menor que o atual");
		}
		this.jogadas = jogadas;
	}

	/** Metodo para retorno doa quantidade de jogadas zeradas do jogo.
     *   @return int - Zeradas do Jogo*/
	public int getJogadasZeradas() {
		return jogadasZeradas;
	}

	/** Metodo para definicao do numero de zeradas do jogo.
     */
	public void setJogadasZeradas(int jogadasZeradas) throws ValorInvalidoException {
		if (jogadasZeradas < this.jogadasZeradas){
			throw new ValorInvalidoException ("O novo numero de jogadas zeradas nao pode ser menor que o atual");
		}
		this.jogadasZeradas = jogadasZeradas;
	}
	
	/** Metodo para retorno da(s) jogabilidade(s) do jogo.
     *   @return HashSet<Jogabilidade> - Jogabilidades do Jogo*/
	public HashSet<Jogabilidade> getJogabilidade() {
		return jogabilidade;
	}

	/** Metodo para definicao da jogabilidade do jogo.
     */
	public void setJogabilidade(HashSet<Jogabilidade> jogabilidade) {
		this.jogabilidade = jogabilidade;
	}

	/** Metodo para registrar uma jogada em um Jogo.
     */
	public int registraJogada(int score, boolean concluido) throws ValorInvalidoException {
		if (score < 0){
			throw new ValorInvalidoException ("O score de uma partida nao pode ser negativo");
		}
		this.jogadas = this.jogadas + 1;
		if (score > this.highScore){
			this.highScore = score;
		}
		if (concluido){
			this.jogadasZeradas = this.jogadasZeradas + 1;
		}
		return 0;
	}
	
	/** Metodo para adicionar uma jogabilidade a um Jogo.
	 * 	 @return boolean - Adicionou Jogabilidade ao Jogo*/
	public boolean addJogabilidade(String jogabilidade){
		for (Jogabilidade jogabilidadeValida : Jogabilidade.values()){
			if (jogabilidadeValida.name().equalsIgnoreCase(jogabilidade)){
				return this.jogabilidade.add(jogabilidadeValida);
			}
		}
		return false;
	}
	
	/** Metodo para adicionar uma jogabilidade a um Jogo.
	 * 	 @return boolean - Adicao de Jogabilidade ao Jogo*/
	public boolean addJogabilidade(Jogabilidade jogabilidade){
		return this.jogabilidade.add(jogabilidade);
	}

	/** Metodo HashCode.
	 * 	 @return int - HashCode*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/** Metodo que retorna a igualdade entre um objeto e um Jogo.
	 * 	 @return boolean - Igualdade entre Jogo*/
	public boolean equals(Object objeto) {
		if (objeto instanceof Jogo){
			Jogo outroJogo = (Jogo) objeto;
			if(outroJogo.getNome().equals(this.getNome())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/** Metodo que retorna a representacao em string do objeto Jogo.
	 * 	 @return String - Representacao em String do Jogo*/
	public abstract String toString();
}
