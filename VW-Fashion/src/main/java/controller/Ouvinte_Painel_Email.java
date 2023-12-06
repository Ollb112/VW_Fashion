package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
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

            // Verifica se os campos não estão vazios (null ou vazio)
            if (!emailText.isEmpty() && !assuntoText.isEmpty() && !mensagemText.isEmpty()) {
                email = new Email();
                boolean envioSucesso = email.enviarEmailParaCliente(emailText, assuntoText, mensagemText);

                if (envioSucesso) {
                    JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao enviar o email.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de enviar.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        } else if (acao.equals("Voltar")) {
            System.out.println("Voltando");
        }
    }

}
