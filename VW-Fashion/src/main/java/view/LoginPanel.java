package view;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Endereco;
import dao.PersistenciaDacException;
import dao.UserDAO;
import model.Cliente;
import model.User;
import ouvintes.OuvinteMouse;

public class LoginPanel extends JPanel{
	
	private  JTextField tfEmail;
	private JTextField pfSenha;
	
	public LoginPanel() {
	
		
	
		setLayout(null);
		
		addLabel("LOGIN", 370, 75, 55, 15, 16);
	
		addLabel("Senha", 232, 130, 40, 30, 12);
		addLabel("Email", 237, 95, 40, 30, 12);
		addTextField();
		addButton("Entrar", 357 , 200, 80, 30);
		addButton("Esqueci minha senha", 320, 160, 155, 16);
		addButton("Criar uma conta", 335, 180, 125, 12);
	}
	
	private void addTextField() {
		tfEmail = new JTextField();
		tfEmail.setBounds(277, 100, 250, 20);
		
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(277, 135, 250, 20);
		pfSenha.setFont(new Font(null, Font.BOLD, 13));
		add(pfSenha);
		add(tfEmail);
		
	}

	private void addButton(String nome, int x, int y, int largura, int altura) {
		JButton botao = new JButton(nome);
		
		botao.setFont(new Font(null, Font.BOLD, 12));
		botao.setBounds(x,y,largura,altura);
		botao.addMouseListener(new OuvinteMouse());
	

		if (nome.equals("Entrar")) {
			botao.setBackground(Color.BLACK);
			botao.setToolTipText("Entra no aplicativo");
			botao.setForeground(Color.WHITE);
		
		} else {
			botao.setOpaque(false);
			botao.setContentAreaFilled(false);
			botao.setBorderPainted(false);
		
		}
		add(botao);
			
	}
	
	private void addLabel(String nome, int x, int y, int largura, int altura, int tamanho) {
		JLabel lblTexto = new JLabel(nome);
		lblTexto.setForeground(Color.black);
		lblTexto.setFont(new Font(null, Font.BOLD, tamanho));
		lblTexto.setBounds(x, y, largura, altura);
		add(lblTexto);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Cliente user = new Cliente();
		Endereco endereco = new Endereco(50, 69, "Rua foda", "Centro");
		
		user.setEndereco(endereco);
		
		user.setEmail("alexdiego@gmail.com");
		
		user.setNome("Diego");
		user.setSenha("123");
		
		UserDAO userDao = new UserDAO();
		try {
			userDao.save(user);
		} catch (PersistenciaDacException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}