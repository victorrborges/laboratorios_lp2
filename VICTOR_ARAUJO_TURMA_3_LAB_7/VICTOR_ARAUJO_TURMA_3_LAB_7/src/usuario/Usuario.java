/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package usuario;

import java.util.HashSet;
import java.util.Set;

import excecoes.StringInvalidaException;
import excecoes.ValorInvalidoException;
import jogo.Jogo;

/** Essa classe representa o objeto Usuario.
 * @author Victor Borges
 */
public class Usuario {

	public static final String FIM_DE_LINHA = System.lineSeparator();

	private String nome;
	private String login;
	private Set<Jogo> meusJogos;
	private double credito;
	private int xp2;
	private TipoDeUsuarioIF statusDoUsuario;

	/** Construtor do objeto Usuario.
     */	
	public Usuario(String nome, String login) throws StringInvalidaException {

		if (nome == null || nome.trim().isEmpty()) {
			throw new StringInvalidaException("Nome nao pode ser nulo ou vazio.");
		}
		if (login == null || login.trim().isEmpty()) {
			throw new StringInvalidaException("Login nao pode ser nulo ou vazio.");
		}

		this.nome = nome;
		this.login = login;
		meusJogos = new HashSet<Jogo>();
		this.credito = 0;
		this.statusDoUsuario = new Noob();
	}

	/** Metodo para retorno do nome do usuario.
     *   @return String - Nome do Usuario*/
	public String getNome() {
		return nome;
	}

	/** Metodo para definicao do nome do usuario.
     */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** Metodo para retorno do login do usuario.
     *   @return String - Login do Usuario*/
	public String getLogin() {
		return login;
	}

	/** Metodo para definicao do login do usuario.
     */
	public void setLogin(String login) {
		this.login = login;
	}

	/** Metodo para retorno dos jogos do usuario.
     *   @return Set<Jogo> - Jogos do Usuario*/
	public Set<Jogo> getMeusJogos() {
		return meusJogos;
	}

	/** Metodo para definicao doos jogos do usuario.
     */
	public void setMeusJogos(Set<Jogo> meusJogos) {
		this.meusJogos = meusJogos;
	}

	/** Metodo para retorno do credito do usuario.
     *   @return double - Credito do Usuario*/
	public double getCredito() {
		return this.credito;
	}

	/** Metodo para definicao do credito do usuario.
     */
	public void setCredito(double novoValor) {
		this.credito = novoValor;
	}

	/** Metodo para retorno do X2P do usuario.
     *   @return int - X2P do Usuario*/
	public int getXp2() {
		return this.xp2;
	}

	/** Metodo para definicao do X2P do usuario.
     */
	public void setXp2(int novoValor) {
		this.xp2 = novoValor;
	}

	/** Metodo para retorno do tipo do usuario.
     *   @return TipoDeUsuarioIF - Tipo do Usuario*/
	public TipoDeUsuarioIF getStatusDoUsuario(){
		//chamada polimorfica
		return this.statusDoUsuario;
	}

	/** Metodo para definicao do tipo do usuario.
     */
	public void setStatusDoUsuario(TipoDeUsuarioIF statusNovo){
		this.statusDoUsuario = statusNovo;
	}

	/** Metodo para comprar um jogo.
     */
	public void compraJogo(Jogo jogo) throws Exception {
		//chamada polimorfica
		double custo = jogo.getPreco() * statusDoUsuario.desconto();
		if(this.buscaJogo(jogo.getNome()) != null){
			throw new StringInvalidaException("Usuario ja possui esse jogo");
		}
		if (custo > this.getCredito()) {
			throw new ValorInvalidoException("Credito insuficiente para realizar a compra.");
		} else {
			int parteInteira =(int)( jogo.getPreco() - (jogo.getPreco() % 1));
			//chamada polimorfica
			int bonusXp =  parteInteira * statusDoUsuario.bonusX2p();
			setXp2(getXp2() + bonusXp);
			setCredito(getCredito() - custo);
			this.cadastraJogo(jogo);
	
		}
	}

	/** Metodo para cadastrar um jogo.
     */
	public void cadastraJogo(Jogo jogo) {
		this.meusJogos.add(jogo);
	}

	/** Metodo para registrar uma nova jogada.
     */
	public void registraJogada(String nomeJogo, int score, boolean venceu) throws Exception {
		Jogo jogo = this.buscaJogo(nomeJogo);
		if (jogo == null) {
			throw new Exception();
		}
		//chamada polimorfica
		setXp2(getXp2() + jogo.registraJogada(score, venceu));
	}
	
	/** Metodo para recompensar um usuario.
     */
	public void recompensar(String nomeJogo,int scoreObtido,boolean zerou) throws StringInvalidaException, Exception {
		registraJogada(nomeJogo, scoreObtido, zerou);
		int x2p = 0;
		Jogo jogo = buscaJogo(nomeJogo);
		//chamada polimorfica
		x2p = statusDoUsuario.recompensar(jogo);
		setXp2(getXp2() + x2p); 
		
	}
	
	/** Metodo para punir um usuario.
     */
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) throws StringInvalidaException, Exception{
		registraJogada(nomeJogo, scoreObtido, zerou);
		int x2p = 0;
		Jogo jogo = buscaJogo(nomeJogo);
		//chamada polimorfica
		x2p = statusDoUsuario.punir(jogo);
		setXp2(getXp2() + x2p); 
	}
	
	/** Metodo para fazer upgrade de usuario.
     */
	public void upgrade(){
		if(this.getXp2() > 1000){
			//chamada polimorfica
			this.statusDoUsuario = new Veterano();
		}
	}
	
	/** Metodo para fazer downgrade de usuario.
     */
	public void downgrade(){
		if(this.getXp2() < 1000){
			//chamada polimorfica
			this.statusDoUsuario = new Noob();
		}
		
	}

	/** Metodo para buscar um Jogo.
     *   @return Jogo - Jogo Buscado*/
	public Jogo buscaJogo(String nomeJogo) {
		Jogo buscado = null;
		for(Jogo jogo : meusJogos){
			if(jogo.getNome().equals(nomeJogo)){
				buscado = jogo;
			}
		}
		return buscado;
	}

	/** Metodo para retorno do preco total dos jogos do usuario.
     *   @return double - Preco dos Jogos do Usuario*/
	public double calculaPrecoTotal() {
		double total = 0;
		
		for(Jogo jogo : meusJogos){
			total = total + jogo.getPreco();
		}
		return total;
	}

	/** Metodo que retorna a igualdade entre um objeto e um Usuario.
	 * 	 @return boolean - Igualdade entre Usuario*/
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario temp = (Usuario) obj;
			return this.getNome().equals(temp.getNome()) && this.getLogin().equals(temp.getLogin());
		} else {
			return false;
		}
	}
	
	/** Metodo que retorna a representacao em string do objeto Usuario.
	 * 	 @return String - Representacao em String do Usuario*/
	public String toString(){
		//chamada polimorfica
		String myString = "Jogador " + this.statusDoUsuario.toString() + ": " + this.getLogin() + FIM_DE_LINHA;
		myString += this.getNome() + " - " + this.getXp2() + " x2p" + FIM_DE_LINHA;
		myString += "Lista de Jogos:" + FIM_DE_LINHA;
		
		for (Jogo jogo : this.getMeusJogos()){
			//chamada polimorfica
			myString = myString + jogo.toString() + FIM_DE_LINHA;
		}
		myString += FIM_DE_LINHA;
		myString += "Total de preco dos jogos: R$ " + this.calculaPrecoTotal() + FIM_DE_LINHA;
		myString += "--------------------------------------------";
		return myString;
	}
}
