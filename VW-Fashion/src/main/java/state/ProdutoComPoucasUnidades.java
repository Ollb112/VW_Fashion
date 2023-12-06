package state;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ProdutoComPoucasUnidades")
public class ProdutoComPoucasUnidades extends EstadoProduto {
    private String estadoAtual = "Poucas unidades";
    
	@Override
	public String getStatus() {
        return estadoAtual;
	}

	@Override
	public void setStatus(String estado) {
		estadoAtual = estado;		
	}
}
