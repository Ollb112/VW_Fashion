package proxySeg;



import criptografia.SHA256;
import model.User;

public class LoginProxy implements LoginBase{

	@Override
	public void fazerLogin(String email, String senha) {
		String senhaHexa = SHA256.criptografar(senha);
				
		Login login = new Login();
		login.fazerLogin(email, senhaHexa);
			
		
		
	}

}
