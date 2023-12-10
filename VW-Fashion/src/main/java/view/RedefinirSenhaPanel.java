package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import controller.OuvinteDeRedefinirSenha;



public class RedefinirSenhaPanel extends JPanel {
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmarSenha;
	private String email;
	
	
	public RedefinirSenhaPanel(String email) {
		this.email = email;
		
		setSize(640,360);
		setLayout(null);
		addPasswordField();
		addLabel();
		addButton();
	}

	private void addButton() {
		JButton botao = new JButton("Redefinir senha");
		botao.setBounds(300, 250, 175, 30);
		botao.setFont(new Font("Arial", Font.BOLD, 14));
		botao.setBackground(Color.BLACK);
		botao.setForeground(Color.WHITE);
		botao.addActionListener(new OuvinteDeRedefinirSenha(pfSenha, pfConfirmarSenha, email));
		add(botao);
		
	}

	private void addLabel() {
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(165, 105, 50, 30);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setBounds(95, 160, 125, 30);
		lblConfirmarSenha.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblConfirmarSenha);
		
	}

	private void addPasswordField() {
		pfSenha = new JPasswordField();
		pfSenha.setBounds(225, 105, 200, 30);
		pfSenha.setFont(new Font("Arial", Font.BOLD, 25));
		add(pfSenha);
		
		pfConfirmarSenha = new JPasswordField();
		pfConfirmarSenha.setBounds(225, 160, 200, 30);
		pfConfirmarSenha.setFont(new Font("Arial", Font.BOLD, 25));
		add(pfConfirmarSenha);
		
		
	}
	
	
	
	

}