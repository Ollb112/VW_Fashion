package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Ouvinte_Painel_Email;
import personalizados.MeuJButton;

public class Painel_Email extends JPanel{
	private int x_Layout = 0;
	private int y_Layout = 0;
	
	private JTextField tfEmail;
	private JTextField tfAssunto;
	private JTextArea taMenssagem;
	private MeuJButton btEnviar;
	private MeuJButton btVoltar;

	public Painel_Email() {
		setLayout(null);
		addLabel("Email", 390 + x_Layout, 20 + y_Layout, 90, 15, 16);
		addLabel("Destinatario:", 200 + x_Layout, 120 + y_Layout, 90, 15, 12);
		addLabel("Assunto:", 200 + x_Layout, 150 + y_Layout, 90, 15, 12);
		addLabel("Menssagem:", 200 + x_Layout, 180 + y_Layout, 90, 15, 12);
		addTextField();
		addJButton();
		setVisible(true);
	}
	
	private void addLabel(String nome, int x, int y, int largura, int altura, int tamanho) {
		JLabel lblTexto = new JLabel(nome);
		lblTexto.setForeground(Color.black);
		lblTexto.setFont(new Font(null, Font.BOLD, tamanho));
		lblTexto.setBounds(x, y, largura, altura);
		add(lblTexto);
	}

	public void addTextField() {
		tfEmail = new JTextField();
		tfAssunto = new JTextField();
		taMenssagem = new JTextArea();
		
		taMenssagem.setBounds(300,180, 250, 80);
		taMenssagem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		taMenssagem.setLineWrap(true);
		JTextField[] campos = { tfEmail, tfAssunto };
		int x = x_Layout + 300;
		int y = y_Layout + 120;

		for (int i = 0; i < campos.length; i++) {
			campos[i].setBounds(x, y, 250, 20);
			y += 30;
			add(campos[i]);
		}
		add(taMenssagem);
	}
	
	public void addJButton() {
		btEnviar = new MeuJButton(200 + x_Layout, 350 + y_Layout,100 ,25 ,"Enviar" );
		btVoltar = new MeuJButton(480 + x_Layout, 350 + y_Layout,100 ,25 ,"Voltar" );
		btEnviar.addActionListener(new Ouvinte_Painel_Email(tfEmail, tfAssunto, taMenssagem));
		btVoltar.addActionListener(new Ouvinte_Painel_Email());
		add(btEnviar);
		add(btVoltar);
	}
	public static void main(String[] args) {
		Janela.setPanel(new Painel_Email());

	}
}
