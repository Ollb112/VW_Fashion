package state;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ProdutoIndisponivel")
public class ProdutoIndisponivel extends EstadoProduto {
    private String estadoAtual = "Indisponivel";

	public String getStatus() {
        return estadoAtual;
	}

	@Override
	public void setStatus(String estado) {
		estadoAtual = estado;		
	}
}