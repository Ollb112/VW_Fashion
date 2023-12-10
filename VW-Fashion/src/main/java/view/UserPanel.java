package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.OuvinteUserPanel;
import model.User;
import model.Vendedor;
import personalizados.MeuJButton;

public class UserPanel extends JPanel{
	private int x_Layout = 0;
	private int y_Layout = 0;
	private User user;
	private JLabel tipoUser;
	
	public UserPanel(User user) {
		this.user = user;
		setLayout(null);
		addButton();
		addLabel();
	}
	
	
	public void addButton() {
		MeuJButton sair = new MeuJButton(20 + x_Layout, 10 + y_Layout, 80, 30, "sair");
		int x = 100;
		sair.addActionListener(new OuvinteUserPanel());
		String[] nomes = {"Caixa", "Registro", "Listar"};
		
		for(String n: nomes) {
			MeuJButton botao = new MeuJButton(x + x_Layout, 300 + y_Layout, 130, 30, n);
			botao.addActionListener(new OuvinteUserPanel());
			x += 200;
			add(botao);
		}
		
		add(sair);
		
	}
	
	public void addLabel() {
		if(user instanceof Vendedor) {
			tipoUser = new JLabel("bem bindo vendedor");
			
		}
		else {
			tipoUser = new JLabel("bem vindo admin!");
		}
		tipoUser.setBounds(300 + x_Layout, 20 + y_Layout, 160, 50);
		JLabel usuario = new JLabel(user.getNome());
		
		usuario.setBounds(300 + x_Layout, 100 + y_Layout, 160, 50);
		add(usuario);
		add(tipoUser);
	}

}
