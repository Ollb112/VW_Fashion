package simpleFactory;

import java.util.List;

import javax.swing.JPanel;

import model.Cliente;
import model.Produto;
import model.User;
import view.EnderecoPanel;
import view.EnviarCodigoPanel;
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
			User.setUser(null);
			return new LoginPanel();
		case "REGISTROUSER":
			return new RegistroUser();
		case "REGISTROPRODUTO":
			return new RegistroProduto();
		case "ENDERECO":
			return new EnderecoPanel((Cliente) user);
		case "USER":
			if(User.getUser() == null)
				User.setUser(user);
			return new UserPanel(User.getUser());
			
		case "CAIXA":
			return new Painel_Caixa();
			
		case "LISTAGEM":
			return new Painel_listagem(tipo);
			
		case "ENVIARCODIGO":
			return new EnviarCodigoPanel();
			
		
		default:
			return null;

		}
		
		

	}
	public static JPanel fabricar(String tipo, User user,float f, List<Produto> p) {
		tipo = tipo.toUpperCase();
		switch (tipo) {
		case "LOGIN":
			User.setUser(null);
			return new LoginPanel();
		case "REGISTROUSER":
			return new RegistroUser();
		case "REGISTROPRODUTO":
			return new RegistroProduto();
		case "ENDERECO":
			return new EnderecoPanel((Cliente) user);
		case "USER":
			if(User.getUser() == null)
				User.setUser(user);
			return new UserPanel(User.getUser());
			
		case "CAIXA":
			return new Painel_Caixa(f,p);
			
		case "LISTAGEM":
			return new Painel_listagem("Produto");
		default:
			return null;

		}

	}
	
	public static JPanel fabricar(String tipo, User user, String condicao) {
		tipo = tipo.toUpperCase();
		switch (tipo) {
		case "LOGIN":
			User.setUser(null);
			return new LoginPanel();
		case "REGISTROUSER":
			return new RegistroUser();
		case "REGISTROPRODUTO":
			return new RegistroProduto();
		case "ENDERECO":
			return new EnderecoPanel((Cliente) user);
		case "USER":
			if(User.getUser() == null)
				User.setUser(user);
			return new UserPanel(User.getUser());
			
		case "CAIXA":
			return new Painel_Caixa();
			
		case "LISTAGEM":
			return new Painel_listagem(condicao);
		default:
			return null;

		}

	}


}
