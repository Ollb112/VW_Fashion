package chainRegistro;

import model.User;

public class VerificadorSenha extends RegistroChain{

	public VerificadorSenha(BaseRegistro proximo) {
		super(proximo);
	}
	
	public boolean processar(User usuario) {
		String senha = usuario.getSenha();
		
		if(senha.length() >= 6 && senha != null) {
			return super.processar(usuario);
		}
		else {
			System.out.println("A senha deve ser ter 6 ou mais caracteres");
			return false;
		}
	}

}
