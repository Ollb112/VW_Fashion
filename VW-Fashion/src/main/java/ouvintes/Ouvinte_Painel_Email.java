package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Email;

public class Ouvinte_Painel_Email implements ActionListener{
	
	private JTextField tfEmail;
	private JTextField tfAssunto;
	private JTextArea tfMenssagem;
	private Email email;
	public Ouvinte_Painel_Email() {
	}
	
	public Ouvinte_Painel_Email(JTextField tfEmail,JTextField tfAssunto, JTextArea tfMenssagem) {
		this.tfEmail = tfEmail;
		this.tfMenssagem = tfMenssagem;
		this.tfAssunto = tfAssunto;
	}
	
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		
		if (acao.equals("Enviar")) {
			String emailText = tfEmail.getText();
			String assuntoText = tfAssunto.getText();
			String mensagemText = tfMenssagem.getText();
			email = new Email();
			email.enviarEmailParaCliente(emailText, assuntoText, mensagemText);
			System.out.println(tfEmail);
			System.out.println(tfAssunto);
			System.out.println(tfMenssagem);

		}
		else if (acao.equals("Voltar"))
			System.out.println("Voltando");

		
	}

}
