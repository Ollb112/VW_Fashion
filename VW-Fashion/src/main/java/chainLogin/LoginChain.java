package chainLogin;


public class LoginChain implements BaseLogin{
	private BaseLogin proximo;
	
	
	public LoginChain(BaseLogin proximo) {
		this.proximo = proximo;
			
	}

	@Override
	public boolean processar(String email, String senha) {
		if(proximo != null)
			return proximo.processar(email, senha);
		else {
			return true;
		}
	}

}
