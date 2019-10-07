/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package usuario;

import java.util.HashSet;

import exceptions.BuscaException;
import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;
import jogo.Jogo;

/** Essa classe representa o objeto Usuario.
 * @author Victor Borges
 */
public abstract class Usuario {
	private String nome;
	private String user;
	private double dinheiro;
	private HashSet<Jogo> jogos;
	private int x2p;
	
	/** Construtor do objeto Usuario.
     */	
	public Usuario(String nome, String user, double dinheiro, int x2p) throws StringInvalidaException, ValorInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException ("O nome do usuario nao pode ser nulo ou vazio");
		}
		if (user == null || user.trim().isEmpty()) {
			throw new StringInvalidaException ("O login do usuario nao pode ser nulo ou vazio");
		}
		if (dinheiro < 0){
			throw new ValorInvalidoException ("A quantidade de dinheiro do usuario nao pode ser menor que zero");
		}
		this.nome = nome;
		this.user = user;
		this.dinheiro = dinheiro;
		this.jogos = new HashSet<Jogo>();
		this.x2p = x2p;
	}

	/** Metodo para retorno do nome do usuario.
     *   @return String - Nome do Usuario*/
	public String getNome() {
		return nome;
	}

	/** Metodo para definicao do nome do usuario.
     */
	public void setNome(String nome) throws StringInvalidaException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException ("O nome do usuario nao pode ser nulo ou vazio");
		}
		this.nome = nome;
	}

	/** Metodo para retorno do user do usuario.
     *   @return String - User do Usuario*/
	public String getUser() {
		return user;
	}

	/** Metodo para definicao do user do usuario.
     */
	public void setUser(String user) throws StringInvalidaException {
		if (user == null || user.trim().isEmpty()) {
			throw new StringInvalidaException ("O login do usuario nao pode ser nulo ou vazio");
		}
		this.user = user;
	}

	/** Metodo para retorno da quantidade de dinheiro do usuario.
     *   @return double - Dinheiro do Usuario*/
	public double getDinheiro() {
		return dinheiro;
	}

	/** Metodo para definicao da quantidade de dinheiro do usuario.
     */
	public void setDinheiro(double dinheiro) throws ValorInvalidoException {
		if (dinheiro < 0){
			throw new ValorInvalidoException ("A quantidade de dinheiro do usuario nao pode ser menor que zero");
		}
		this.dinheiro = dinheiro;
	}

	/** Metodo para retorno dos jogos do usuario.
     *   @return HashSet<Jogo> - Jogos do Usuario*/
	public HashSet<Jogo> getJogos() {
		return jogos;
	}

	/** Metodo para definicao doos jogos do usuario.
     */
	public void setJogos(HashSet<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	/** Metodo para retorno do X2P do jogo.
     *   @return int - X2P do Usuario*/
	public int getX2p() {
		return x2p;
	}

	/** Metodo para definicao do X2P do usuario.
     */
	public void setX2p(int x2p) throws ValorInvalidoException {
		if (x2p < this.getX2p()){
			throw new ValorInvalidoException ("A nova quantidade de X2P nao pode ser menor do que a quantidade atual");
		}
		this.x2p = x2p;
	}
	
	/** Metodo para adicionar dinheiro ao usuario.
     */
	public void addDinheiro(double dinheiro) throws ValorInvalidoException {
		if (dinheiro < 0){
			throw new ValorInvalidoException ("Voce nao pode adicionar um valor negativo de dinheiro");
		}
		this.dinheiro = this.dinheiro + dinheiro;
	}
	
	/** Metodo para comprar um jogo.
     *   @return boolean - Compra de Jogo pelo Usuario*/
	public abstract boolean compraJogo(Jogo jogo) throws StringInvalidaException, ValorInvalidoException, BuscaException, Exception;
		
	
	/** Metodo para adicionar jogo ao usuario.
     *   @return boolean - Adicao de Jogo no Usuario*/
	public boolean  addJogo(Jogo jogo){
		return this.jogos.add(jogo);
	}
	
	/** Metodo para retornar se o usuario possui um jogo.
     *   @return boolean - Usuario Possui Jogo*/
	public boolean contemJogo(Jogo jogo){
		return this.jogos.contains(jogo);
	}
	
	/** Metodo para retornar se o usuario possui um jogo.
     *   @return boolean - Usuario Possui Jogo*/
	public boolean contemJogo(String nomeJogo){
		for(Jogo jogo : jogos){
			if (jogo.getNome().equals(nomeJogo)){
				return true;
			}
		}
		return false;
	}
	
	/** Metodo para registrar uma jogada.
     *   @return boolean - Registro de jogada do Usuario*/
	public boolean registraJogada(String nomeJogo, int score, boolean concluido) throws StringInvalidaException, ValorInvalidoException {
		for (Jogo jogo : jogos){
			if (jogo.getNome().equals(nomeJogo)){
				this.setX2p(this.getX2p() + jogo.registraJogada(score, concluido)); 
				return true;
			}
		}
		return false;
	}

	/** Metodo HashCode.
	 * 	 @return int - HashCode*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/** Metodo que retorna a igualdade entre um objeto e um Usuario.
	 * 	 @return boolean - Igualdade entre Usuario*/
	public boolean equals(Object objeto) {
		if (objeto instanceof Usuario){
			Usuario outroUsuario = (Usuario) objeto;
			if (outroUsuario.getUser().equals(this.getUser())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	} 
	
	/** Metodo que retorna a representacao em string do objeto Usuario.
	 * 	 @return String - Representacao em String do Usuario*/
	public abstract String toString();
	
	
}
