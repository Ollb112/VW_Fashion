package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.User;
import simpleFactory.FactoryMethod;
import view.Janela;

public class OuvinteUserPanel implements ActionListener {
	
	
	private User user;
	
	public OuvinteUserPanel(User user){
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao.toUpperCase()) {
			case "CAIXA":
				Janela.setPanel(FactoryMethod.fabricar("caixa", null));
				break;
				
			case "REGISTRO":
				String[] opcoes = {"produto", "usuario"};
				String escolha = (String) JOptionPane.showInputDialog(Janela.getInstance(), "Qual desses voce ira cadastrar", null, JOptionPane.QUESTION_MESSAGE, null, opcoes, "VWF");
				if(escolha.equals("produto"))
					Janela.setPanel(FactoryMethod.fabricar("registroProduto", null));
				else
					Janela.setPanel(FactoryMethod.fabricar("RegistroUser", user));
				break;
				
			case "LISTAR":
				Janela.setPanel(FactoryMethod.fabricar("listagem", null));
				break;
			
			case "SAIR":
				Janela.setPanel(FactoryMethod.fabricar("login", null));		
				break;
				
		}

	}

}
