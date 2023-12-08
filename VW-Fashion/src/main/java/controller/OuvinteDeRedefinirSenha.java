package controller;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


import criptografia.SHA256;
import dao.PersistenciaDacException;
import dao.UserDAO;
import model.User;
import simpleFactory.FactoryMethod;
import view.Janela;

public class OuvinteDeRedefinirSenha implements ActionListener{

	
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmarSenha;
	private String email;
	
	public OuvinteDeRedefinirSenha(JPasswordField pfSenha, JPasswordField pfConfirmarSenha, String email) {
		this.pfSenha = pfSenha;
		this.pfConfirmarSenha = pfConfirmarSenha;
		this.email = email;
		
		
	}
	
	public void actionPerformed(ActionEvent clique) {
		
		
		
		String senha = new String(pfSenha.getPassword());
		String confirmarSenha = new String(pfConfirmarSenha.getPassword());
		
		if(senha.equals(confirmarSenha) == false) {
			JOptionPane.showMessageDialog(Janela.getInstance(), "As senhas precisam ser iguais!");
		}
		else if(senha.isBlank() || senha.isBlank()) {
			JOptionPane.showMessageDialog(Janela.getInstance(), "Preencha todos os campos!");
		}
		else {
			UserDAO dao = new UserDAO();
			try {
				User user = dao.getByID(email);
				user.setSenha(SHA256.criptografar(senha));
				dao.update(user);
			} catch (PersistenciaDacException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(Janela.getInstance(), "Senha alterada com sucesso!");
			Janela.setPanel(FactoryMethod.fabricar("login", null));
		}
		
		
	}
	

}