package model;

public class Endereco {
	private long idEndereco;
	private long cep;
	private int numero;
	private String rua;
	private String bairro;
	
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
