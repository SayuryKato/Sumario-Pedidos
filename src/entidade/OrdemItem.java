package entidade;

public class OrdemItem {
	
	private int quantidade;
	private double preco;
	
	private Produto produto;
	

	public OrdemItem(int quantidade, double preco, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public double SubTotal() {
		return quantidade * preco;
	}

	@Override
	public String toString() {
		return  produto.getNome() +", $"+String.format("%.2f", preco)+", Quantidade: "+quantidade + ", Subtotal: $"+String.format("%.2f", SubTotal());
	}
	
	
	

}
