package chainLogin;

import javax.swing.JOptionPane;


import view.Janela;

public class VerificadorSenha extends LoginChain{

	public VerificadorSenha(LoginChain proximo) {
		super(proximo);
	}
	
	public boolean processar(String email, String senha) {
	
		
		if(senha != null) {
			return super.processar(email, senha);
		}
		else {
			JOptionPane.showMessageDialog(Janela.getInstance(), "Senha invalida!");
			return false;
		}
	}

}
