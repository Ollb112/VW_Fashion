package state;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ProdutoIndisponivel")
public class ProdutoIndisponivel extends EstadoProduto {
	
	 @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_ProdutoIndisponivel")
    private EstadoProduto estadoatual;
    
	public EstadoProduto getStatus() {
        return estadoatual;
	}

	@Override
	public void setStatus(int quantidade) {
		if (quantidade > 5) {	
		estadoatual = new ProdutoDisponivel();
    } else if (quantidade > 0) {
    	estadoatual = new ProdutoComPoucasUnidades();
    } else {
    	estadoatual = new ProdutoIndisponivel();
    }
		
	}
}