package personalizados;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MeuJLabel extends JLabel {
	public MeuJLabel(int x, int y, int l, int a,String nome) {
		this.setForeground(Color.black);
		this.setBounds(x,y,l,a);
		this.setText(nome);
	}

	
	public MeuJLabel(int x, int y, int l, int a,String nome,Color c) {
		this.setBounds(x,y,l,a);
		this.setText(nome);
		this.setForeground(c);
	}

}
