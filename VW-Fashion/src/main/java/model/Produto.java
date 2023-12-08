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

import state.EstadoProduto;

@Entity
@Table(name = "TB_Produto")
public class Produto {
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_estado")
	 private EstadoProduto estado;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto")
	private long idProduto;
	
	@Column(name = "Preco")
	private float preco;
	
	@Column(name = "Marca")
	private String marca;
	
	@Column(name = "NomeProduto")
	private String nomeProduto;
	
	@Column(name = "Quantidade")
	private int quantidade;
	

   

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_add_ids")
	private Pedido pedido;
	
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
	
	public EstadoProduto getEstado() {
		return estado;
	}
	public void setEstado(EstadoProduto estado) {
		this.estado = estado;
	}
	
	public Produto() {
		
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if (quantidade > 5)
			estado.setStatus("Disponivel");
		else if (quantidade < 0 & quantidade != 0)
			estado.setStatus("Poucas Unidades");
		else
			estado.setStatus("Indisponivel");
		
		this.quantidade = quantidade;
	}

}
