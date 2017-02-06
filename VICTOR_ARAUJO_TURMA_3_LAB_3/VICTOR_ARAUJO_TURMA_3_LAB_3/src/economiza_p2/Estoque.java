/* 115210597 - Victor Eduardo Borges de Araujo: LAB 3 - Turma 3 */

package economiza_p2;

public class Estoque {
	
	private int quantidadeDeProdutos;
	
	private Produto[] produtosCadastrados;

	public Estoque() {
		this.produtosCadastrados = new Produto[1];
	}
	
	public int getQuantidadeDeProdutos(){
		return quantidadeDeProdutos;
	}
	
	public void setQuantidadeDeProdutos(int quantidadeDeProdutos){
		this.quantidadeDeProdutos = quantidadeDeProdutos;
	}

	public Produto[] getProdutosCadastrados(){
		return produtosCadastrados;
	}

	public void setProdutosCadastrados(Produto novoProduto){
		
		dupliqueArray();

		produtosCadastrados[quantidadeDeProdutos] = novoProduto;
		setQuantidadeDeProdutos(quantidadeDeProdutos + 1);
		
	}

	public void dupliqueArray() {
		if (quantidadeDeProdutos == produtosCadastrados.length) {
			Produto[] produtosCadastrados2 = new Produto[quantidadeDeProdutos * 2];
			System.arraycopy(produtosCadastrados, 0, produtosCadastrados2, 0, produtosCadastrados.length);
			produtosCadastrados = produtosCadastrados2;
		}
	}

	public Produto buscarProduto(String produtoParaVender) {

		Produto produtoBuscado = null;
		
		for (int i = 0; i < produtosCadastrados.length; i = i + 1) {
			
			if (produtosCadastrados[i] != null){
				if (produtoParaVender.equalsIgnoreCase(produtosCadastrados[i].getNome())) {
					produtoBuscado = produtosCadastrados[i];
				}
			}
		}
		return produtoBuscado;
	}

	public String toString(int i){
		return produtosCadastrados[i].toString() + " Restante: " + produtosCadastrados[i].getQuantidadeNoEstoque(); 
	}
}
