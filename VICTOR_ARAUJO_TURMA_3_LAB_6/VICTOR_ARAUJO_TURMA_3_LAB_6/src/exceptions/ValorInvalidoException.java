/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package exceptions;

public class ValorInvalidoException extends Exception {
	public ValorInvalidoException(){
		super("Valor invalido");
	}
	public ValorInvalidoException(String mensagem){
		super(mensagem);
	}
}
