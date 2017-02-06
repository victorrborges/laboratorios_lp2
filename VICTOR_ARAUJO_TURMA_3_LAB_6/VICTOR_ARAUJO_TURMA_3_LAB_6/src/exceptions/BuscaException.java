/* 115210597 - Victor Eduardo Borges de Araujo: LAB 6 - Turma 3 */

package exceptions;

public class BuscaException extends Exception {
	public BuscaException(){
		super("Busca invalida");
	}
	public BuscaException(String mensagem){
		super(mensagem);
	}
}