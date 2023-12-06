package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.User;
import proxySeg.LoginBase;
import proxySeg.LoginProxy;
import simpleFactory.FactoryMethod;
import view.Janela;
import view.RegistroUser;

public class OuvinteLogin implements ActionListener {
	private JTextField emailCampo;
	private JPasswordField senhaCampo;

	public OuvinteLogin(JTextField emailCampo, JPasswordField senhaCampo) {
		this.emailCampo = emailCampo;

		this.senhaCampo = senhaCampo;

	}

	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		
		LoginBase login = new LoginProxy();
		


		if (acao.equals("Entrar")) {
			User user = login.fazerLogin(emailCampo.getText(), senhaCampo.getText());
			if(user != null){
				Janela.setPanel(FactoryMethod.fabricar("user", user));
			}
			else {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Usuario invalido!");
			}
			
		}
		
			
		else if(acao.equals("Esqueci minha senha")) {
			System.out.println("Falta programar a logica do esqueci senha");
		}
		

	}

}
