package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import observer.MensageiroBase;

@Entity
@Table(name = "TB_Cliente")
public class Cliente extends User implements MensageiroBase{
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id")
	private Endereco endereco;
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public Cliente() {
		
	}

	@Override
	public void enviarEmail(String assunto, String mensagem) {
		Email mensageiro = new Email();
		mensageiro.enviarEmailParaCliente(getEmail(), assunto, mensagem);
		
	}

}
