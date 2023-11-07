package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long idEndereco;
	
	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;
	
	
	
	private long cep;
	private int numero;
	private String rua;
	private String bairro;
	
	
	public Endereco(long cep, int numero, String rua, String bairro) {
		this.cep = cep;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
	}
	
	public Endereco() {
		
	}
	
	public long getId_endereco() {
		return idEndereco;
	}
	public void setId_endereco(long id_endereco) {
		this.idEndereco = id_endereco;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long cep) {
		this.cep = cep;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
}
