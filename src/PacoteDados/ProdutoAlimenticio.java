package PacoteDados;

public class ProdutoAlimenticio extends Produto {
	private String dataValidade;
	
	public ProdutoAlimenticio (String nomeProduto, String codigoProduto, String descricao, double precoCusto, double precoVenda, int quantidadecompra, int quantidadeVenda, int quantidadeEstoque, String dataValidade) {
		super(nomeProduto, codigoProduto, descricao, precoCusto, precoVenda, quantidadecompra, quantidadeVenda, quantidadeEstoque);
		this.dataValidade = dataValidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}
	public void setValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}
