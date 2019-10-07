/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package exceptions;

public class TipoInvalidoException extends Exception {
	public TipoInvalidoException(){
		super("Tipo invalido");
	}
	public TipoInvalidoException(String mensagem){
		super(mensagem);
	}
}