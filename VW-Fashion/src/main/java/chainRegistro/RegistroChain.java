package chainRegistro;

import model.User;

public class RegistroChain implements BaseRegistro{
	private BaseRegistro proximo;
	
	
	public RegistroChain(BaseRegistro proximo) {
		this.proximo = proximo;
			
	}

	@Override
	public boolean processar(User usuario) {
		if(proximo != null)
			return proximo.processar(usuario);
		else {
			return true;
		}
	}

}
