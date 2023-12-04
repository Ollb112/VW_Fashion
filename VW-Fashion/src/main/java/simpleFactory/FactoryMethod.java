package simpleFactory;

import javax.swing.JPanel;

import model.Cliente;
import model.User;
import view.EnderecoPanel;
import view.LoginPanel;
import view.Painel_Caixa;
import view.Painel_listagem;
import view.RegistroProduto;
import view.RegistroUser;
import view.UserPanel;

public class FactoryMethod {

	public static JPanel fabricar(String tipo, User user) {
		tipo = tipo.toUpperCase();
		switch (tipo) {
		case "LOGIN":
			return new LoginPanel();
		case "REGISTROUSER":
			return new RegistroUser(user);
		case "REGISTROPRODUTO":
			return new RegistroProduto(user);
		case "ENDERECO":
			return new EnderecoPanel((Cliente) user);
		case "USER":
			return new UserPanel(user);
			
		case "CAIXA":
			return new Painel_Caixa();
			
		case "LISTAGEM":
			return new Painel_listagem();

		default:
			return null;

		}

	}

}
