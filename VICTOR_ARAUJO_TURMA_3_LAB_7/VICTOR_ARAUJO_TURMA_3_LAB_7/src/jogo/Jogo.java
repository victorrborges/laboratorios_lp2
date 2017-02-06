/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package jogo;

import java.util.HashSet;
import java.util.Set;

import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;

/** Essa classe representa o objeto Jogo.
 * @author Victor Borges
 */
public abstract class Jogo {
	public static final String FIM_DE_LINHA = System.lineSeparator();

	private String nome;
	private double preco;
	private int vezesJogadas;
	private int vezesConcluidas;
	private int maiorScore;
	Set<Jogabilidade> jogabilidades;

	/** Construtor do objeto Jogo sem jogabilidades.
     */	
	public Jogo(String nome, double preco) throws StringInvalidaException, PrecoInvalidoException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException("Preco nao pode ser negativo");
		}

		this.nome = nome;
		this.preco = preco;
		this.vezesConcluidas = 0;
		this.vezesJogadas = 0;
		this.maiorScore = 0;
		jogabilidades = new HashSet<Jogabilidade>();
	}

	/** Construtor do objeto Jogo com jogabilidades.
     */	
	public Jogo(String nome, double preco, Set<Jogabilidade> jogabilidades)
			throws StringInvalidaException, PrecoInvalidoException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (preco < 0) {
			throw new PrecoInvalidoException("Preco nao pode ser negativo");
		}

		this.nome = nome;
		this.preco = preco;
		this.vezesConcluidas = 0;
		this.vezesJogadas = 0;
		this.maiorScore = 0;
		this.jogabilidades = jogabilidades;
	}

	/** Metodo para retorno do nome do jogo.
     *   @return String - Nome do Jogo*/
	public String getNome() {
		return this.nome;
	}

	/** Metodo para retorno do preco do jogo.
     *   @return double - Preco do Jogo*/
	public double getPreco() {
		return this.preco;
	}

	/** Metodo para retorno da quantidade de jogadas do jogo.
     *   @return int - Jogadas do Jogo*/
	public int getVezesJogadas() {
		return this.vezesJogadas;
	}

	/** Metodo para definicao do numero de jogadas do jogo.
     */
	public void setVezesJogadas(int novaQuantidade) {
		this.vezesJogadas = novaQuantidade;
	}

	/** Metodo para retorno doa quantidade de jogadas concluidas do jogo.
     *   @return int - Jogadas Concluidas do Jogo*/
	public int getVezesConcluidas() {
		return this.vezesConcluidas;
	}

	/** Metodo para definicao do numero de jogadas concluidas do jogo.
     */
	public void setVezesConcluidas(int novaQuantidade) {
		this.vezesConcluidas = novaQuantidade;
	}

	/** Metodo para retorno do maior score do jogo.
     *   @return int - Maior Score do Jogo*/
	public int getMaiorScore() {
		return this.maiorScore;
	}

	/** Metodo para definicao do maior score do jogo.
     */
	public void setMaiorScore(int novoScore) {
		this.maiorScore = novoScore;
	}

	/** Metodo para retorno da(s) jogabilidade(s) do jogo.
     *   @return HashSet<String> - Jogabilidades do Jogo*/
	public HashSet<String> getJogabilidades(){
		HashSet<String> jogabilidades = new HashSet<String>();
		for (Jogabilidade jogabilidade : this.jogabilidades){
			jogabilidades.add(jogabilidade.name());
		}
		return jogabilidades;
	}

	/** Metodo para registrar uma jogada em um Jogo.
     */
	public abstract int registraJogada(int score, boolean venceu);

	/** Metodo que retorna a igualdade entre um objeto e um Jogo.
	 * 	 @return boolean - Igualdade entre Jogo*/
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Jogo) {
			Jogo temp = (Jogo) obj;
	
			return this.getNome().equals(temp.getNome()) && this.getPreco() == temp.getPreco();
	
		} else {
			return false;
		}
	
	}

	/** Metodo que retorna a representacao em string do objeto Jogo.
	 * 	 @return String - Representacao em String do Jogo*/
	@Override
	public String toString() {
		String resultado = "==> Jogou " + getVezesJogadas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Zerou " + getVezesConcluidas() + " vez(es)" + FIM_DE_LINHA;
		resultado += "==> Maior Score: " + getMaiorScore() + FIM_DE_LINHA;
		return resultado;
	}
}
