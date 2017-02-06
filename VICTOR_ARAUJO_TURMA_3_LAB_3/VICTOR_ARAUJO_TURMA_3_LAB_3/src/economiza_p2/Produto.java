/* 115210597 - Victor Eduardo Borges de Araujo: LAB 3 - Turma 3 */

package economiza_p2;

public class Produto {
	
	private String nome;
	private double preco;
	private String tipo;
	private int quantidadeNoEstoque;
	
	public Produto(String nomeProduto, double precoProduto, String tipoProduto, int quantidadeNoEstoqueProduto){
		
		nome = nomeProduto;
		preco = precoProduto;
		tipo = tipoProduto;
		quantidadeNoEstoque = quantidadeNoEstoqueProduto;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String novoNome){
		nome = novoNome;
	}
	
	public double getPreco(){
		return preco;
	}
	
	public void setPreco(double novoPreco){
		preco = novoPreco;
	}
	
	public  String getTipo(){
		return tipo;
	}
	
	public void setTipo(String novoTipo){
		tipo = novoTipo;
	}

	public int getQuantidadeNoEstoque(){
		return quantidadeNoEstoque;
	}
	
	public void setQuantidadeNoEstoque(int novaQuantidadeNoEstoque){
		quantidadeNoEstoque = novaQuantidadeNoEstoque;
	}

	public String toString(){
		return getNome() +" (" + getTipo() + "). R$" + getPreco();
	}
}