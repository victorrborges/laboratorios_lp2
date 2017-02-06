/* 115210597 - Victor Eduardo Borges de Araujo: LAB 3 - Turma 3 */

package economiza_p2;

public class SuperMercado {
	
	public EntradaDeDados leitor = new EntradaDeDados();

	public double valorTotalAcumulado;
	
	public Estoque estoque = new Estoque();
	
	public void cadastreProduto(){
		
		System.out.println("= = = = Cadastro de Produtos = = = =");
		
		String cadastrarOutroProduto;
		
		do{
			System.out.print("Digite o nome do produto: ");
			String nomeProduto = leitor.lerString();
			System.out.print("Digite o preco unitario do produto: ");
			double precoProduto = leitor.lerDouble();
			System.out.print("Digite o tipo do produto: ");
			String tipoProduto = leitor.lerString();
			System.out.print("Digite a quantidade no estoque: ");
			int quantidadeNoEstoqueProduto = leitor.lerInteiro();
			System.out.println(quantidadeNoEstoqueProduto + " \"" + nomeProduto + "\"" + " cadastrado(s) com sucesso.");
			System.out.println();
		
			Produto novoProduto = new Produto(nomeProduto, precoProduto, tipoProduto, quantidadeNoEstoqueProduto);
			
			estoque.setProdutosCadastrados(novoProduto);
			
			System.out.print("Deseja cadastrar outro produto? ");
			cadastrarOutroProduto = leitor.lerString();
			System.out.println();	
			
			} while(cadastrarOutroProduto.equalsIgnoreCase("Sim"));	
		
		System.out.println("= = = = = = = = = = = = = = = = = = =");
		System.out.println();
		
		}
	
	public void vendaProduto (){
		
		System.out.println("= = = = Venda de Produtos = = = =");
		
		int quantosProdutosVendera = 0;
		
		int estoqueRestante = 0;
		
		valorTotalAcumulado = 0;
		
		String venderOutroProduto;
		
		do{			
			System.out.print("Digite o nome do produto: ");
			String produtoParaVender = leitor.lerString();
			
			Produto produtoVerificado = estoque.buscarProduto(produtoParaVender);
			
			if (produtoVerificado != null){
				System.out.println("==> " + produtoVerificado);
				System.out.println();
				System.out.print("Digite a quantidade que deseja vender: ");
				quantosProdutosVendera = leitor.lerInteiro();
				
				if (quantosProdutosVendera <= produtoVerificado.getQuantidadeNoEstoque()){
					valorTotalAcumulado = valorTotalAcumulado + (quantosProdutosVendera * produtoVerificado.getPreco());
					System.out.printf("==> Total arrecadado: R$ " + "%.2f" ,valorTotalAcumulado);
					System.out.println();
					
					estoqueRestante = produtoVerificado.getQuantidadeNoEstoque() - quantosProdutosVendera;
					produtoVerificado.setQuantidadeNoEstoque(estoqueRestante);
					
				} else {
					System.out.println("Nao eh possivel vender pois nao ha " + produtoVerificado.getNome() + " suficiente.");
				}
				
			} else {
				System.out.println("==> " + produtoParaVender + " nao cadastrado no sistema.");
			}
			
			System.out.print("Deseja vender outro produto? ");
			venderOutroProduto = leitor.lerString();
			System.out.println();
			
		} while (venderOutroProduto.equalsIgnoreCase("Sim"));	
		
		System.out.println("= = = = = = = = = = = = = = = = = = =");
		System.out.println();
		
	} 

	public void imprimaBalanco(){
		
		System.out.println("= = = = Impressao de Balanco = = = =");
		System.out.println("Produtos cadastrados: ");
		int indice = 1;
		for (int i = 0; i < estoque.getQuantidadeDeProdutos(); i = i + 1){
			System.out.print("    " + indice + ") " + estoque.toString(i));
			System.out.println();
			indice = indice + 1;
		}

		System.out.println();
		System.out.printf("Total arrecadado em vendas: " + "%.2f" ,valorTotalAcumulado);
		System.out.println();
		
		double totalDisponivel = 0;
		
		for (int i = 0; i < estoque.getQuantidadeDeProdutos(); i = i + 1){
			totalDisponivel = totalDisponivel + estoque.getProdutosCadastrados()[i].getPreco() * estoque.getProdutosCadastrados()[i].getQuantidadeNoEstoque();
		}
		
		System.out.printf("Total que pode ser arrecadado: %.2f", totalDisponivel);
		System.out.println();
		System.out.println();
		System.out.println("= = = = = = = = = = = = = = = = = = =");
		System.out.println();
		
	}
}