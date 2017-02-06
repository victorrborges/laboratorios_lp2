/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package usuario;

import excecoes.StringInvalidaException;

/** Essa classe representa o Factory de Usuario.
 * @author Victor Borges
 */
public class FactoryUsuario {
	
	/** Metodo para criar um Usuario.
     *   @return Usuario - Usuario criado*/
	public Usuario criaUsuario(String nome, String user, String tipo) throws StringInvalidaException {
		Usuario usuario = null;
		if (tipo.equalsIgnoreCase("Noob")){
			usuario = new Usuario(nome, user);
		} else if (tipo.equalsIgnoreCase("Veterano")){
			usuario = new Usuario(nome, user);
			usuario.setStatusDoUsuario(new Veterano());
		}
		return usuario;
	}
}
