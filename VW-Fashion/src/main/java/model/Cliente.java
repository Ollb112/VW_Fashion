package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Cliente")
public class Cliente extends User {
	
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

}
