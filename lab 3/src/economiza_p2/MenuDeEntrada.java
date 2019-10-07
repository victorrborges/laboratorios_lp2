/* 115210597 - Victor Eduardo Borges de Araujo: LAB 3 - Turma 3 */

package economiza_p2;

public class MenuDeEntrada {

	public SuperMercado mercado = new SuperMercado();
	
	public EntradaDeDados leitor = new EntradaDeDados();
	
	public static final int SAIR = 4;

	public static final int CADASTRO = 1;

	public static final int VENDA = 2;

	public static final int IMPRIMA = 3;

	public void menuPrincipal() {

		System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =");

		int opcao;

		do {
			System.out.println("Digite a opcao desejada:");
			System.out.println("1 - Cadastrar um Produto");
			System.out.println("2 - Vender um Produto");
			System.out.println("3 - Imprimir Balanco");
			System.out.println("4 - Sair");
			System.out.println("");
			System.out.print("Opcao: ");
			opcao = leitor.lerInteiro();
			System.out.println();

			if (opcao == CADASTRO) {

				mercado.cadastreProduto();

			} else if (opcao == VENDA) {

				mercado.vendaProduto();

			} else if (opcao == IMPRIMA) {

				mercado.imprimaBalanco();

			}
		} while (opcao != SAIR);
	}
}
