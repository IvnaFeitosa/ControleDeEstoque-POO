package PacoteDados;

public class ProdutoAlimenticio extends Produto {
	private String dataValidade;
	
	public ProdutoAlimenticio (String nomeProduto, String codigoProduto, String descricao, double precoCusto, double precoVenda, int quantidadeCompra, int quantidadeVenda, int quantidadeEstoque,int tipoProduto, String dataValidade) {
		super(nomeProduto, codigoProduto, descricao, precoCusto, precoVenda, quantidadeCompra, quantidadeVenda, quantidadeEstoque, tipoProduto);
		this.dataValidade = dataValidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}
	public void setValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	@Override
	public String toString() {
		return super.toString() + "; \nData de validade: "+this.getDataValidade()+"\n";
	}
}
