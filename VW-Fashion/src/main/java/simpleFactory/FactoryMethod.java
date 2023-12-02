package simpleFactory;

import javax.swing.JPanel;

import model.*;
import view.*;

public class FactoryMethod {

	public static JPanel fabricar(String tipo, User user) {
		tipo = tipo.toUpperCase();
		switch (tipo) {
		case "LOGIN":
			return new LoginPanel();
		case "REGISTRO":
			return new Registro();
		case "ENDERECOPANEL":
			return new EnderecoPanel((Cliente) user);
		case "USERPANEL":
			return new UserPanel(user);

		default:
			return null;

		}

	}

}
