package chainRegistro;

import model.User;

public class VerificadorEmail extends RegistroChain{

	public VerificadorEmail(BaseRegistro proximo) {
		super(proximo);
		
	}
	
	
	public boolean processar(User usuario) {
		String email = usuario.getEmail();
		System.out.println(email);
		if(email != null && email.contains("@") && email.contains(".")) {
			
			return super.processar(usuario);
		}
		else {
			System.out.println("Email invalido");
			return false;
		}
	}

}
