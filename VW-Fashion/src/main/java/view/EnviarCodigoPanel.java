package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.OuvinteDoEnviarCodigoPanel;
import model.User;



public class EnviarCodigoPanel extends JPanel {
	
	private JTextField tfEmail;
	private static String codigo;

	
	public static String getCodigo() {
		return codigo;
	}
	
	public static void setCodigo(String c) {
		codigo = c;
	}
	
	public EnviarCodigoPanel() {
		
		setLayout(null);
		
	
		addLabel();
		addTextField();
		addButton();
	}
	

	private void addTextField() {
		JTextField tfCodigo = new JTextField();
		

		tfEmail = new JTextField();
		tfEmail.setBounds(200, 125, 200, 30);
		
		
	
		
		tfCodigo.setBounds(275, 210, 55, 20);
		tfCodigo.setFont(new Font(null, Font.BOLD, 13));
		tfCodigo.addKeyListener(new OuvinteDoEnviarCodigoPanel(tfEmail));
		add(tfCodigo);
		add(tfEmail);
		
	}

	private void addButton() {
		String[] botoes = {"Enviar código", "Cancelar"};
		int x = 180;
		
		for(int i = 0; i < botoes.length; i++) {
			JButton btnEnviar = new JButton(botoes[i]);
			btnEnviar.setBounds(x, 160,115,30);
			btnEnviar.setFont(new Font(null, Font.BOLD, 12));
			
			btnEnviar.addActionListener(new OuvinteDoEnviarCodigoPanel(tfEmail));
			btnEnviar.setBackground(new Color(0,0,0));
			btnEnviar.setForeground(Color.WHITE);
			add(btnEnviar);
			
			x += 143;
		}
		
	}

	private void addLabel() {
		
		JLabel lblRedefinirSenha = new JLabel("Redefinir Senha");
		lblRedefinirSenha.setBounds(240, 100, 140, 15);
		lblRedefinirSenha.setFont(new Font("Arial", Font.BOLD, 16));
		add(lblRedefinirSenha);
		
	}
	

}