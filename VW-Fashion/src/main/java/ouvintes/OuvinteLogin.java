package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.PersistenciaDacException;
import dao.UserDAO;
import model.User;
import view.Janela;
import view.Registro;

public class OuvinteLogin implements ActionListener {
	private String emailCampo;
	private String senhaCampo;

	public OuvinteLogin(JTextField emailCampo, JPasswordField senhaCampo) {
		this.emailCampo = emailCampo.getText();

		this.senhaCampo = senhaCampo.getText();

	}

	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
	
		UserDAO dao = new UserDAO();

		if (acao.equals("Entrar")) {
			try {
				User user = dao.getByID(emailCampo);
				
				if (user.getSenha().equals(senhaCampo)) {
					System.out.println("Colocar logica de entrar");
				}
				else {
					System.out.println("Senha errada");
				}
			} catch (PersistenciaDacException e1) {
				
				e1.printStackTrace();
			}
		}
		else if(acao.equals("Esqueci minha senha")) {
			System.out.println("Falta programar a logica do esqueci senha");
		}
		else if(acao.equals("Criar uma conta")) {
			Janela.setPanel(new Registro());
		}

	}

}
