package PacoteDados;
public class Produto {
	private String nomeProduto;
	private String codigoProduto;
	private String descricao;
	private double precoCusto;
	private double precoVenda;
	private int quantidadeCompra;
	private int quantidadeVenda;
	private int quantidadeEstoque;
	private int tipoProduto;
	
	public Produto () {
		
	}
	public Produto (String nomeProduto, String codigoProduto, String descricao, double precoCusto, double precoVenda, int quantidadeVenda, int quantidadeCompra, int quantidadeEstoque, int tipoProduto ) {
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.quantidadeCompra = quantidadeCompra;
		this.quantidadeVenda = quantidadeVenda;
		this.quantidadeEstoque = quantidadeEstoque;
		this.tipoProduto = tipoProduto;
	}
	public Produto (String nomeProduto, String codigoProduto, String descricao, double precoCusto, double precoVenda ) {
		this.nomeProduto = nomeProduto;
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		
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
	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}
	public void setQuantidadeCompra(int quantidadeCompra) {
		this.quantidadeCompra = quantidadeCompra;
	}
	public int getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(int tipoProduto) {
		this.tipoProduto = tipoProduto;
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
	
	@Override
	public String toString() {
		return "\n\n-------------------------\n\n"+"Código do produto = " + codigoProduto + "; \nNome do produto = " + nomeProduto + "; \nDescrição do produto = " + descricao
				+ "; \nPreço de custo = " + precoCusto + "; \nPreço de venda = " + precoVenda + 
				"; \nQuantidade de compra = " + quantidadeCompra + "; \nQuantidade vendida = " + quantidadeVenda + 
				"; \nQuantidade em estoque = " + quantidadeEstoque;
		
	}
}