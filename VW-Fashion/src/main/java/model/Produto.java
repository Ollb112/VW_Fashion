package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Produto")
public class Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto")
	private long idProduto;
	
	@Column(name = "Preco")
	private int preco;
	
	@Column(name = "Marca")
	private String marca;
	
	@Column(name = "NomeProduto")
	private String nomeProduto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_add_ids")
	private Pedido pedido;
	
	@Column(name = "quantidade")
	private int quantidade;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
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
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public String getNome_produto() {
		return nomeProduto;
	}
	public void setNome_produto(String nome_produto) {
		this.nomeProduto = nome_produto;
	}
	
	public Produto() {
		
	}
	

}
