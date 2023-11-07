package personalizados;

import java.awt.Color;


import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MeuJButton extends JButton{
	
	
	public MeuJButton(String nome, int x, int y, int largura, int altura){
		setText(nome);
		this.setBounds(x, y, largura, altura);
	}
	
	public MeuJButton(String caminhoDoIcone, String nome, int x, int y, int largura, int altura){
		this.setText(nome);
		this.setIcon(new ImageIcon(caminhoDoIcone));
		this.setBounds(x, y, largura, altura);
	}
	public MeuJButton(Color cor, String nome, int x, int y, int largura, int altura){
		this.setText(nome);
		this.setBackground(cor);
		this.setBounds(x, y, largura, altura);
	}

}