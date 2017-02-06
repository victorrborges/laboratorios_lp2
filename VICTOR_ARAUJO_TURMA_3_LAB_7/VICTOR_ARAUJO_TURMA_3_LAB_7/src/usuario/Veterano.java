/* 115210597 - Victor Eduardo Borges de Araujo: LAB 7 - Turma 3 */

package usuario;

import excecoes.StringInvalidaException;
import jogo.Jogo;

/** Essa classe representa o objeto Veterano(Usuario).
 * @author Victor Borges
 */
public class Veterano implements TipoDeUsuarioIF {
	public static final double DESCONTO_VETERANO = 0.8;
	
	public static final int BONUS_VETERANO = 15;

	/** Construtor do objeto Veterano(Usuario).
     */	
	public Veterano() {
	
	}

	/** Metodo para retorno do desconto de um usuario veterano.
     *   @return double - Desconto do Veterano(Usuario)*/
	public double desconto(){
		return DESCONTO_VETERANO;
	}
	
	/** Metodo para retorno do bonus de um usuario veterano.
     *   @return int - Bonus do Veterano(Usuario)*/
	public int bonusX2p(){
		return BONUS_VETERANO;
	}
	
	/** Metodo para recompensar um usuario veterano.
     *   @return int - Recompensa do Veterano(Usuario)*/
	public int recompensar(Jogo jogo) throws StringInvalidaException, Exception {
		int x2p = 0;
		if (jogo == null){
			throw new StringInvalidaException("Jogo nao encontrado");
		}
		for (String jogabilidade : jogo.getJogabilidades()){
			if (jogabilidade.equals("ONLINE")){
				x2p = x2p + 10;
			}
			if (jogabilidade.equals("COOPERATIVO")){
				x2p = x2p + 20;
			}
		}
		return x2p; 
	}
	
	/** Metodo para punir um usuario veterano.
     *   @return int - Punicao do Veterano(Usuario)*/
	public int punir(Jogo jogo) throws StringInvalidaException, Exception {
		int x2p = 0;
		if (jogo == null){
			throw new StringInvalidaException("Jogo nao encontrado");
		}
		for (String jogabilidade : jogo.getJogabilidades()){
			if (jogabilidade.equals("OFFLINE")){
				x2p = x2p - 20;
			}else if (jogabilidade.equals("COMPETITIVO")){
				x2p = x2p - 20;
			}
		}
		return x2p;
	}

	/** Metodo que retorna a representacao em string do objeto Veterano(Usuario).
	 * 	 @return String - Representacao em String de Veterano(Usuario)*/
	@Override
	public String toString() {
		return "Veterano";
	}

}
