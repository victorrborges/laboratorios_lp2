/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import excecoes.PrecoInvalidoException;
import excecoes.StringInvalidaException;
import excecoes.UpgradeInvalidoException;
import excecoes.ValorInvalidoException;
import jogo.FactoryJogo;
import jogo.Jogabilidade;
import jogo.Jogo;
import usuario.FactoryUsuario;
import usuario.Usuario;

/** Essa classe representa o objeto LojaController.
 * @author Victor Borges
 */
public class LojaController {
	public static final String FIM_DE_LINHA = System.lineSeparator();
	private FactoryJogo factoryJogo;
	private FactoryUsuario factoryUsuario;
	private List<Usuario> meusUsuarios;
	private HashMap<String, Jogabilidade> mapJogabilidades;

	/** Construtor do objeto LojaController.
     */	
	public LojaController() {
		this.meusUsuarios = new ArrayList<Usuario>();
		this.initializeMap();
		this.factoryJogo = new FactoryJogo();
		this.factoryUsuario = new FactoryUsuario();
	}

	/** Metodo para criar um Usuario.
     */
	public void criaUsuario(String nome, String login, String tipoUsuario) {
		try {
			meusUsuarios.add(factoryUsuario.criaUsuario(nome, login, tipoUsuario));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/** Metodo para vender um Jogo.
     */
	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser) {

		try {
			Usuario buscado = this.buscaUsuario(loginUser);
			Set<Jogabilidade> tiposJogabilidades = this.createJogabilidades(jogabilidades);
			Jogo jogoVendido = this.criaJogo(jogoNome, preco, tiposJogabilidades, estiloJogo);
			//chamada polimorfica
			buscado.compraJogo(jogoVendido);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/** Metodo para recompensar um usuario.
     */
	public void recompensar(String login, String nomeJogo, int scoreObtido, boolean zerou){
		try {
			//chamada polimorfica
			buscaUsuario(login).recompensar(nomeJogo, scoreObtido, zerou);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/** Metodo para punir um usuario.
     */
	public void punir(String login, String nomeJogo, int scoreObtido, boolean zerou){
		try {
			//chamada polimorfica
			buscaUsuario(login).punir(nomeJogo, scoreObtido, zerou);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/** Metodo para adicionar credito a um usuario.
     */
	public void adicionaCredito(String login, double credito) {
		try {
			if (credito < 0) {
				throw new ValorInvalidoException("Credito nao pode ser negativo");
			}
			Usuario user = this.buscaUsuario(login);
			user.setCredito(user.getCredito() + credito);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/** Metodo para buscar um usuario.
     *   @return Usuario - Usuario Buscado*/
	public Usuario buscaUsuario(String login) {
		Usuario buscado = null;

		try {
			for (Usuario usuario : meusUsuarios){
				if (usuario.getLogin().equals(login)){
					buscado = usuario;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return buscado;
	}

	/** Metodo para fazer upgrade de usuario.
     */
	public void upgrade(String login) throws Exception {
		Usuario usuario = this.buscaUsuario(login);
		if (usuario.getClass().getSimpleName().equalsIgnoreCase("veterano")) {
			throw new UpgradeInvalidoException("Upgrade impossivel de ser realizado, usuario ja eh veterano");
		} else if (usuario.getXp2() < 1000) {
			throw new UpgradeInvalidoException("Impossivel realizar upgrade, quantidade de x2p insuficiente!");
		}
		//chamada polimorfica
		usuario.upgrade();

	}
	
	/** Metodo para fazer downgrade de usuario.
     */
	public void downgrade(String login) throws Exception {
		Usuario usuario  = this.buscaUsuario(login);
		if (usuario.getClass().getSimpleName().equalsIgnoreCase("noob")){
			throw new UpgradeInvalidoException("Downgrade impossivel de ser realizado, usuario ja eh noob");
		} else if (usuario.getXp2() > 1000) {
		throw new UpgradeInvalidoException("Impossivel realizar downgrade, usuario tem x2p suficiente para permanecer veterano!");
		}
		//chamada polimorfica
		usuario.downgrade();
	}

	/** Metodo para retorno do credito de um usuario.
     *   @return double - Credito de um Usuario*/
	public double confereCredito(String login) {
		try {
			Usuario procurado = this.buscaUsuario(login);
			return procurado.getCredito();
		} catch (Exception e) {
			e.getMessage();
		}
		return 0;
	}

	/** Metodo que retorna a informacao dos usuarios.
	 * 	 @return String - Informacao dos Usuarios*/
	public String informacaoUsuarios() {
		String myString = "=== Central P2-CG ===" + FIM_DE_LINHA + FIM_DE_LINHA;
		for (int i = 0; i < meusUsuarios.size(); i++) {
			//chamada polimorfica
			myString += meusUsuarios.get(i).toString() + FIM_DE_LINHA;
		}
		return myString;
	}

	/** Metodo para retorno do X2P do usuario.
     *   @return int - X2P do Usuario*/
	public int getX2p(String login) {
		Usuario buscado = this.buscaUsuario(login);
		return buscado.getXp2();
	}

	/** Metodo para criar um Jogo.
     *   @return Jogo - Jogo criado*/
	private Jogo criaJogo(String nome, double preco, Set<Jogabilidade> jogabilidades, String estilo)
			throws StringInvalidaException, PrecoInvalidoException {
		return factoryJogo.criaJogo(nome, preco, jogabilidades, estilo);
		
	}

	/** Metodo para criar Jogabilidades.
     *   @return Set<Jogabilidade> - Jogabilidades criadas*/
	private Set<Jogabilidade> createJogabilidades(String names1) {
		Set<Jogabilidade> jogabilidades = new HashSet<Jogabilidade>();

		String[] listofNames = names1.split(" ");

		for (int i = 0; i < listofNames.length; i++) {
			String element = listofNames[i].toUpperCase();
			if (element != null) {
				Jogabilidade tipojogabilidade = mapJogabilidades.get(element);
				jogabilidades.add(tipojogabilidade);
			}
		}

		return jogabilidades;

	}

	/** Metodo para inicializar o mapa.
     */
	private void initializeMap() {
		this.mapJogabilidades = new HashMap<String, Jogabilidade>();
		mapJogabilidades.put("ONLINE", Jogabilidade.ONLINE);
		mapJogabilidades.put("OFFLINE", Jogabilidade.OFFLINE);
		mapJogabilidades.put("COMPETITIVO", Jogabilidade.COMPETITIVO);
		mapJogabilidades.put("COOPERATIVO", Jogabilidade.COOPERATIVO);
		mapJogabilidades.put("MULTIPLAYER", Jogabilidade.MULTIPLAYER);

	}

}
