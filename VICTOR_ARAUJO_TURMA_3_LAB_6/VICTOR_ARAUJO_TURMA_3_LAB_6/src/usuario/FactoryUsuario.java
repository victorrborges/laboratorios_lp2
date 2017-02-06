/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package usuario;

import exceptions.StringInvalidaException;
import exceptions.ValorInvalidoException;

/** Essa classe representa o Factory de Usuario.
 * @author Victor Borges
 */
public class FactoryUsuario {
	
	/** Metodo para criar um Usuario.
     *   @return Usuario - Usuario criado*/
	public Usuario criarUsuario(String nome, String user, double dinheiro, String tipo) throws StringInvalidaException, ValorInvalidoException {
		Usuario usuario = null;
		if (tipo.equalsIgnoreCase("veterano")){
			usuario = new Veterano(nome, user, dinheiro); 
		} else if (tipo.equalsIgnoreCase("noob")){
			usuario = new Noob(nome, user, dinheiro);
		}
		return usuario;
	}
}
