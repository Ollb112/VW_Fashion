package proxySeg;

import javax.swing.JOptionPane;

import chainLogin.VerificadorEmail;
import chainLogin.VerificadorSenha;
import dao.PersistenciaDacException;
import dao.UserDAO;
import model.User;
import simpleFactory.FactoryMethod;
import view.Janela;

public class Login implements LoginBase{

	@Override
	public void fazerLogin(String email, String senha) {
		UserDAO dao = new UserDAO();
		VerificadorEmail verificador = new VerificadorEmail(new VerificadorSenha(null));
		try {
			User user = dao.getByID(email);
			if(verificador.processar(email, senha) == true){
				if(user.getSenha().equals(senha)) {
				Janela.setPanel(FactoryMethod.fabricar("user", user));
				}
				else {
					JOptionPane.showMessageDialog(Janela.getInstance(), "Senha invalida");
				}
			}
		} catch (PersistenciaDacException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
