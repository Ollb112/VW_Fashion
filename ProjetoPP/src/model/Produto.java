package model;

public class Produto {
	private long idProduto;
	private float preco;
	private String marca;
	private String nomeProduto;
	
	public long getId_produto() {
		return idProduto;
	}
	public void setId_produto(long id_produto) {
		this.idProduto = id_produto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getNome_produto() {
		return nomeProduto;
	}
	public void setNome_produto(String nome_produto) {
		this.nomeProduto = nome_produto;
	}
	

}
