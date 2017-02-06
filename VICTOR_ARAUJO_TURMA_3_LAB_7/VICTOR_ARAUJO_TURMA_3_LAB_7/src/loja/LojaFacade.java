/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package loja;

import easyaccept.EasyAccept;

/** Essa classe representa o objeto LojaFacade.
 * @author Victor Borges
 */
public class LojaFacade {
	private LojaController lojaController;
	
	/** Construtor do objeto LojaFacade.
     */	
	public LojaFacade(){
		this.lojaController = new LojaController();
	}
	
	/** Metodo para criar um Usuario.
     */
	public void criaUsuario(String nome, String login, String tipoUsuario){
		lojaController.criaUsuario(nome, login, tipoUsuario);
	}
	
	/** Metodo para vender um Jogo.
     */
	public void vendeJogo(String jogoNome, double preco, String jogabilidades, String estiloJogo, String loginUser){
		lojaController.vendeJogo(jogoNome, preco, jogabilidades, estiloJogo, loginUser);
	}
	
	/** Metodo para recompensar um usuario.
     */
	public void recompensar(String login, String nomeJogo, int scoreObtido, boolean zerou){
		lojaController.recompensar(login, nomeJogo, scoreObtido, zerou);
	}
	
	/** Metodo para punir um usuario.
     */
	public void punir(String login, String nomeJogo, int scoreObtido, boolean zerou){
		lojaController.punir(login, nomeJogo, scoreObtido, zerou);
	}
	
	/** Metodo para adicionar credito a um usuario.
     */
	public void adicionaCredito(String login, double credito){
		lojaController.adicionaCredito(login, credito);
	}
	
	/** Metodo para fazer upgrade de usuario.
     */
	public void upgrade(String login) throws Exception {
		lojaController.upgrade(login);
	}
	
	/** Metodo para fazer downgrade de usuario.
     */
	public void downgrade (String login) throws Exception {
		lojaController.downgrade(login);
	}
	
	/** Metodo para retorno do credito de um usuario.
     *   @return double - Credito de um Usuario*/
	public double confereCredito(String login) {
		return lojaController.confereCredito(login);
	}
	
	/** Metodo que retorna a informacao dos usuarios.
	 * 	 @return String - Informacao dos Usuarios*/
	public String informacaoUsuarios() {
		return lojaController.informacaoUsuarios();
	}

	/** Metodo para retorno do X2P do usuario.
     *   @return int - X2P do Usuario*/
	public int getX2p(String login) {
		return lojaController.getX2p(login);
	}
	
	/** Metodo main.
     */
	public static void main(String[] args) {
		args = new String[] { "loja.LojaFacade", "acceptance_test/us1.txt", "acceptance_test/us2.txt",  "acceptance_test/us3.txt" };
		EasyAccept.main(args);
	}
}
