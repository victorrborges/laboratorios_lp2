/* 115210597 - Victor Eduardo Borges de Araujo: LAB 3 - Turma 3 */

package economiza_p2;

import java.util.*;

public class EntradaDeDados {
	
	public Scanner scanner = new Scanner(System.in);
	
	public int lerInteiro(){
		int inteiro = scanner.nextInt();
		scanner.nextLine();
		return inteiro;
	}
	
	public double lerDouble(){
		double decimal = scanner.nextDouble();
		scanner.nextLine();
		return decimal;
	}
	
	public String lerString(){
		String string = scanner.nextLine();
		return string;
	}

}
