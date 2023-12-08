package view;

import java.awt.Color;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.OuvinteEnderecoPanel;
import model.Cliente;
import controller.OuvinteMouse;
import personalizados.MeuJButton;

public class EnderecoPanel extends JPanel {
	private int x_Layout = 60; // mudar esse valor muda o X de todos os objetos
	private int y_Layout = 0; // mudar esse valor muda o Y de todos os objetos

	private JTextField ruaCampo;
	private JTextField bairroCampo;
	private JTextField numeroCampo;
	private JFormattedTextField cepCampo;
	private Cliente cliente;

	public EnderecoPanel(Cliente cliente) {
		this.cliente = cliente;
		setLayout(null);

		addJLabels();
		adicionarTextField();
		adicionarJButton();

	}

	public void addJLabels() {

		String[] labels = { "rua", "bairro", "CEP", "numero" };

		int x = x_Layout + 200;
		int y = y_Layout + 30;

		for (int i = 0; i < labels.length; i++) {
			JLabel label = new JLabel(labels[i]);
			label.setForeground(Color.black);
			label.setBounds(x, y, 100, 50);
			y += 50;
			add(label);
		}

	}

	public void adicionarTextField() {
		ruaCampo = new JTextField("");
		bairroCampo = new JTextField("");
		numeroCampo = new JTextField("");

		try {
			cepCampo = new JFormattedTextField(new MaskFormatter("#######"));
		} catch (ParseException e) {
		}

		JTextField[] campos = { ruaCampo, bairroCampo, cepCampo, numeroCampo };

		int x = x_Layout + 250;
		int y = y_Layout + 40;

		for (int i = 0; i < campos.length; i++) {
			campos[i].setBounds(x, y, 200, 30);
			y += 50;
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
			botao.addActionListener(new OuvinteEnderecoPanel(cliente, ruaCampo, bairroCampo, numeroCampo, cepCampo));
			add(botao);
		}

	}

}
