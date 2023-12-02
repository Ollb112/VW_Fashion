package proxySeg;



import criptografia.SHA256;
import model.User;

public class LoginProxy implements LoginBase{

	@Override
	public User fazerLogin(String email, String senha) {
		String senhaHexa = SHA256.criptografar(senha);
				
		Login login = new Login();
		return login.fazerLogin(email, senhaHexa);
			
		
		
	}

}
