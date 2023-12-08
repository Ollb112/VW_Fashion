package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.OuvinteMouse;
import controller.OuvinteRegistroUser;
import model.Administrador;
import model.User;
import model.Vendedor;
import personalizados.MeuJButton;

public class RegistroUser extends JPanel {
	int x_Layout = 0;
	int y_Layout = 0;

	private JTextField usuarioCampo;
	private JTextField emailCampo;
	private JFormattedTextField nascimentoCampo;
	private JPasswordField senhaCampo;
	private JPasswordField senhaCampoConfirmar;
	private JRadioButton cliente;
	private JRadioButton fornecedor;
	private JRadioButton vendedor;
	
	
	public RegistroUser() {
		
		setLayout(null);

		
		addLabel();
		adicionarTextField();
		
		if(User.getUser() != null)
			adicionarRadioButtons();
		adicionarJButton();

	}
	

	public void adicionarRadioButtons() {
		ButtonGroup grupo = new ButtonGroup();
		if(User.getUser() instanceof Vendedor) {
			cliente = new JRadioButton("Cliente", true);
		}
		else {
			cliente = new JRadioButton("Cliente", false);
			
			vendedor = new JRadioButton("Vendedor", true);
			vendedor.setBounds(230, 230, 100, 30);
		
			
			grupo.add(vendedor);
			add(vendedor);
		}
		
		fornecedor = new JRadioButton("Fornecedor", false);
		
		

		cliente.setBounds(330, 230, 100, 30);
		fornecedor.setBounds(430, 230, 100, 30);

		
		
		
		
		grupo.add(cliente);
		grupo.add(fornecedor);

		add(fornecedor);
		add(cliente);
	}

	public void addLabel() {
		String[] labels = { "Usuario", "Email", "Senha", "Confirmar senha", "Nascimento" };
		int x = x_Layout + 200;
		int y = y_Layout + 40;

		for (int i = 0; i < labels.length; i++) {
			JLabel label = new JLabel(labels[i]);
			label.setBounds(x, y, 120, 30);
			label.setForeground(Color.black);
			y += 40;
			if (i == 2) {
				x -= 60;
			}
			if (i == 3) {
				x += 30;
			}

			add(label);
		}
	}

	

	public void adicionarTextField() {
		usuarioCampo = new JTextField("");
		emailCampo = new JTextField("");
		try {
			nascimentoCampo = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
		}
		senhaCampo = new JPasswordField("");
		senhaCampoConfirmar = new JPasswordField("");

		JTextField[] campos = { usuarioCampo, emailCampo, senhaCampo, senhaCampoConfirmar, nascimentoCampo };
		int x = x_Layout + 250;
		int y = y_Layout + 40;

		for (int i = 0; i < campos.length; i++) {
			campos[i].setBounds(x, y, 200, 30);
			if (i == 4) {
				campos[i].setBounds(x, y, 70, 30);
			}
			y += 40;
			add(campos[i]);
		}

	}

	public void adicionarJButton() {

		String[] botoes = { "enviar", "cancelar" };
		int x = x_Layout + 210;
		int y = y_Layout + 265;
		for (int i = 0; i < botoes.length; i++) {
			MeuJButton botao = new MeuJButton(botoes[i], x, y, 85, 35);
			botao.addMouseListener(new OuvinteMouse());
			x += 130;
			botao.addActionListener(new OuvinteRegistroUser(usuarioCampo, emailCampo,
					senhaCampo, senhaCampoConfirmar, nascimentoCampo, cliente, fornecedor, vendedor));
			add(botao);
		}
		
	
	}
	
}

