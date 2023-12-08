package state;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ProdutoDisponivel")
public class ProdutoDisponivel extends EstadoProduto {
    private String estadoAtual = "Disponivel";
    
	public String getStatus() {
        return estadoAtual;
	}

	@Override
	public void setStatus(String estado) {
		estadoAtual = estado;		
	}
}
