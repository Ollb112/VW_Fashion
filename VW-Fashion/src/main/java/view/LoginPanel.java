package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.OuvinteLogin;
import controller.OuvinteMouse;
import simpleFactory.FactoryMethod;

public class LoginPanel extends JPanel {
	private int x_Layout = 0;
	private int y_Layout = 0;

	private JTextField tfEmail;
	private JPasswordField pfSenha;

	public LoginPanel() {

		setLayout(null);

		addLabel("LOGIN", 370 + x_Layout, 75 + y_Layout, 55, 15, 16);

		addLabel("Senha", 232 + x_Layout, 130 + y_Layout, 40, 30, 12);
		addLabel("Email", 237 + x_Layout, 95 + y_Layout, 40, 30, 12);
		addTextField();
		addButton("Entrar", 357 + x_Layout, 200 + y_Layout, 80, 30);
		addButton("Esqueci minha senha", 320 + x_Layout, 160 + y_Layout, 155, 16);
		
	}

	private void addTextField() {
		tfEmail = new JTextField();
		pfSenha = new JPasswordField();

		JTextField[] campos = { tfEmail, pfSenha };
		int x = x_Layout + 277;
		int y = y_Layout + 100;

		for (int i = 0; i < campos.length; i++) {
			campos[i].setBounds(x, y, 250, 20);
			y += 35;
			add(campos[i]);
		}

	}

	private void addButton(String nome, int x, int y, int largura, int altura) {
		JButton botao = new JButton(nome);

		botao.setFont(new Font(null, Font.BOLD, 12));
		botao.setBounds(x, y, largura, altura);
		botao.addMouseListener(new OuvinteMouse());
		botao.addActionListener(new OuvinteLogin(tfEmail, pfSenha));

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
		Janela.setPanel(FactoryMethod.fabricar("login", null));

	}

}