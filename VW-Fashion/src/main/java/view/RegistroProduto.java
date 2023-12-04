package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.User;
import ouvintes.OuvinteMouse;
import ouvintes.OuvinteRegistroProduto;
import personalizados.MeuJButton;

public class RegistroProduto extends JPanel{
	
	int x_Layout = 50;
	int y_Layout = 50;

	private JTextField nomeCampo;
	private JTextField marca;
	private JTextField quantidade;
	private JTextField precoCampo;
	private User user;
	

	public RegistroProduto(User user) {
		setLayout(null);
		this.user = user;

		

		addLabel();
		
		adicionarTextField();
		adicionarJButton();

	}


	public void addLabel() {
		String[] labels = { "Nome", "Marca", "Preco", "Quantidade"};
		int x = x_Layout + 200;
		int y = y_Layout + 40;

		for (int i = 0; i < labels.length; i++) {
			JLabel label = new JLabel(labels[i]);
			
			if (i == 3) {
				x += 110;
				y -= 40;
			}
			
			label.setBounds(x, y, 120, 30);
			label.setForeground(Color.black);
			y += 40;
			
			add(label);
		}
	}

	

	public void adicionarTextField() {
		nomeCampo = new JTextField("");
		marca = new JTextField("");
		quantidade = new JTextField("");
		precoCampo = new JTextField("");
	

		JTextField[] campos = { nomeCampo, marca, precoCampo, quantidade};
		int x = x_Layout + 250;
		int y = y_Layout + 40;

		for (int i = 0; i < campos.length; i++) {
			campos[i].setBounds(x, y, 200, 30);
			if (i == 2) {
				campos[i].setBounds(x, y, 50, 30);
			}
			if(i == 3) {
				campos[i].setBounds(x + 130, y - 40, 50, 30);
			}
			y += 40;
			add(campos[i]);
		}

	}

	public void adicionarJButton() {

		String[] botoes = { "enviar", "cancelar" };
		int x = x_Layout + 230;
		int y = y_Layout + 185;
		for (int i = 0; i < botoes.length; i++) {
			MeuJButton botao = new MeuJButton(botoes[i], x, y, 85, 35);
			botao.addMouseListener(new OuvinteMouse());
			botao.addActionListener(new OuvinteRegistroProduto(nomeCampo, marca, quantidade, precoCampo, user));
			x += 130;
			add(botao);
		}

	}

}
