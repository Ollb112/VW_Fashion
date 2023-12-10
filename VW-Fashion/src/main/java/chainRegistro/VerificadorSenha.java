package chainRegistro;

import javax.swing.JOptionPane;

import model.User;
import view.Janela;

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
			JOptionPane.showMessageDialog(Janela.getInstance(), "A senha deve ter 6 ou mais caracteres!");
			return false;
		}
	}

}
