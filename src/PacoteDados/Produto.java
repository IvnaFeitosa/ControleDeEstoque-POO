package PacoteDados;
public class Produto {
	private String nomeProduto;
	private String codigoProduto;
	private String descricao;
	private double precoCusto;
	private double precoVenda;
	private int quantidadecompra;
	private int quantidadeVenda;
	private int quantidadeEstoque;
	
	public Produto () {
		
	}
	public Produto (String nomeProduto, String codigoProduto, String descricao, double precoCusto, double precoVenda, int quantidadecompra, int quantidadeVenda, int quantidadeEstoque ) {
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.quantidadecompra = quantidadecompra;
		this.quantidadeVenda = quantidadeVenda;
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Produto (String nomeProduto, String codigoProduto, String descricao, double precoCusto, double precoVenda ) {
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		
	}
	public Produto(String nomeProduto, String descricao, double precoCusto, double precoVenda,
			int quantidadeEstoque, int quantidadeVenda, int quantidadecompra) {
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.quantidadecompra = quantidadecompra;
		this.quantidadeVenda = quantidadeVenda;
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public int getQuantidadecompra() {
		return quantidadecompra;
	}
	public void setQuantidadecompra(int quantidadecompra) {
		this.quantidadecompra = quantidadecompra;
	}
	public int getQuantidadeVenda() {
		return quantidadeVenda;
	}
	public void setQuantidadeVenda(int quantidadeVenda) {
		this.quantidadeVenda = quantidadeVenda;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
}