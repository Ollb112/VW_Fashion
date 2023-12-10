package controller;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;


import javax.swing.JPasswordField;
import javax.swing.JTextField;

import proxySeg.LoginBase;
import proxySeg.LoginProxy;
import simpleFactory.FactoryMethod;
import view.Janela;


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
			login.fazerLogin(emailCampo.getText(), senhaCampo.getText());
			
		}
		
		
			
		else if(acao.equals("Esqueci minha senha")) {
			Janela.setPanel(FactoryMethod.fabricar("enviarCodigo", null));
		}
		

		}
	
}
