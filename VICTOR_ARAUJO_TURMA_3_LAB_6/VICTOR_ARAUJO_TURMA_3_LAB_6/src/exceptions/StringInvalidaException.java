/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package exceptions;

public class StringInvalidaException extends Exception {
	public StringInvalidaException(){
		super("String invalida");
	}
	public StringInvalidaException(String mensagem){
		super(mensagem);
	}
}
