package proxySeg;

import javax.swing.JOptionPane;

import dao.PersistenciaDacException;
import dao.UserDAO;
import model.User;
import view.Janela;

public class Login implements LoginBase{

	@Override
	public User fazerLogin(String email, String senha) {
		UserDAO dao = new UserDAO();
		try {
			User user = dao.getByID(email);
			if(user.getSenha().equals(senha));{
				return user;
			}
		} catch (PersistenciaDacException e) {
			JOptionPane.showMessageDialog(Janela.getInstance(), "Email não existe");
			e.printStackTrace();
		}
		System.out.println("Senha errada");
		return null;
	}

}
