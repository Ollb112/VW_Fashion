package state;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Produto;
@Entity
@Table(name = "TB_EstadoProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EstadoProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_EstadoProduto")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_id")
	private Produto produto;
	
    public abstract EstadoProduto getStatus();
    public abstract void setStatus(int quantidade);
    
   

}
