/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package usuario;

import jogo.Jogo;
import excecoes.StringInvalidaException;

/** Essa interface define o objeto Usuario.
 * @author Victor Borges
 */
public interface TipoDeUsuarioIF {
	
	/** Metodo para retorno do desconto de um usuario.
     *   @return double - Desconto do Usuario*/
	public double desconto();
	
	/** Metodo para retorno do bonus de um usuario.
     *   @return int - Bonus do Usuario*/
	public int bonusX2p();
	
	/** Metodo para recompensar um usuario.
     *   @return int - Recompensa do Usuario*/
	public int recompensar(Jogo jogo) throws StringInvalidaException, Exception;
	
	/** Metodo para punir um usuario.
     *   @return int - Punicao do Usuario*/
	public int punir(Jogo jogo) throws StringInvalidaException, Exception;
	
	/** Metodo que retorna a representacao em string do objeto Usuario.
	 * 	 @return String - Representacao em String de Usuario*/
	public String toString();
}
