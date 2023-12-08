package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Estoque")
public class Estoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Estoque")
	private long idEstoque;
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public long getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(long idEstoque) {
		this.idEstoque = idEstoque;
	}
	
	public Estoque() {
		
	}
}
