/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package usuario;

import excecoes.StringInvalidaException;
import jogo.Jogo;

/** Essa classe representa o objeto Noob(Usuario).
 * @author Victor Borges
 */
public class Noob implements TipoDeUsuarioIF {
	
	public static final double DESCONTO_NOOB = 0.85;

	public static final int BONUS_NOOB = 10;
	
	/** Construtor do objeto Noob(Usuario).
     */	
	public Noob()  {
		
	}

	/** Metodo para retorno do desconto de um usuario noob.
     *   @return double - Desconto do Noob(Usuario)*/
	public double desconto(){
		return DESCONTO_NOOB;
	}
	
	/** Metodo para retorno do bonus de um usuario noob.
     *   @return int - Bonus do Noob(Usuario)*/
	public int bonusX2p() {
		return BONUS_NOOB;
	}
	
	/** Metodo para recompensar um usuario noob.
     *   @return int - Recompensa do Noob(Usuario)*/
	public int recompensar(Jogo jogo) throws StringInvalidaException, Exception {
		int x2p = 0;
		if (jogo == null){
			throw new StringInvalidaException("Jogo nao encontrado");
		}
		for (String jogabilidade : jogo.getJogabilidades()){
			if (jogabilidade.equals("OFFLINE")){
				x2p = x2p + 30;
			}
			if (jogabilidade.equals("MULTIPLAYER")){
				x2p = x2p + 10;
			}
		}
		return x2p;
	}
	
	/** Metodo para punir um usuario noob.
     *   @return int - Punicao do Noob(Usuario)*/
	public int punir(Jogo jogo) throws StringInvalidaException, Exception {
		int x2p = 0;
		if (jogo == null){
			throw new StringInvalidaException("Jogo nao encontrado");
		}
		for (String jogabilidade : jogo.getJogabilidades()){
			if (jogabilidade.equals("ONLINE")){
				x2p = x2p - 10;
			}
			if (jogabilidade.equals("COMPETITIVO")){
				x2p = x2p - 20;
			}
			if (jogabilidade.equals("COOPERATIVO")){
				x2p = x2p - 50;
			}
		}
		return x2p;
	}

	/** Metodo que retorna a representacao em string do objeto Noob(Usuario).
	 * 	 @return String - Representacao em String de Noob(Usuario)*/
	@Override
	public String toString() {
		return "Noob";
	}

}