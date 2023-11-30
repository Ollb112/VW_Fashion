package personalizados;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ouvintes.OuvinteMouse;

public class MeuJButton extends JButton{

	public MeuJButton(int x, int y, int l, int a, String s) {
		this.setBounds(x,y,l,a);
		this.setText(s);
	}
	public MeuJButton(int x, int y, int l, int a, String s, Color c) {
		this.setBounds(x,y,l,a);
		this.setText(s);
		this.setForeground(c);
	}
	
	public MeuJButton(int x, int y, int l, int a, Color c, String s, Color b) {
		this.setBounds(x,y,l,a);
		this.setText(s);
		this.setForeground(c);
		this.setBackground(b);
	}
}