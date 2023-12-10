package chainRegistro;

import javax.swing.JOptionPane;

import model.User;
import view.Janela;

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
			JOptionPane.showMessageDialog(Janela.getInstance(), "Emai invalido!");
			return false;
		}
	}

}
