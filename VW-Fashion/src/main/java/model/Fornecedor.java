package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Fornecedor")
public class Fornecedor extends User{
	private String tipo_produto;
	private long idFornecedor;
	
	public String getTipo_produto() {
		return tipo_produto;
	}
	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}
	public long getId_fornecedor() {
		return idFornecedor;
	}
	public void setId_fornecedor(long id_fornecedor) {
		this.idFornecedor = id_fornecedor;
	}
	
	
	public Fornecedor() {
		
	}
}
