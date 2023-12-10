package chainLogin;

import javax.swing.JOptionPane;

import dao.PersistenciaDacException;
import dao.UserDAO;
import view.Janela;

public class VerificadorEmail extends LoginChain{

	public VerificadorEmail(BaseLogin proximo) {
		super(proximo);
		
	}
	
	
	public boolean processar(String email, String senha) {
		UserDAO dao = new UserDAO();
		try {
			if (dao.getByID(email) == null) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Esse email não existe!");
				return false;
				
			}
			else if(email != null && email.contains("@") && email.contains(".")) {
				
				return super.processar(email, senha);
			}
		} catch (PersistenciaDacException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(Janela.getInstance(), "Email invalido");
		return false;
		
	}

}
