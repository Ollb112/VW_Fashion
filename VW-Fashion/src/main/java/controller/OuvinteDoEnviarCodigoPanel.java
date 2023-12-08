      package controller;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Email;

import simpleFactory.FactoryMethod;
import view.EnviarCodigoPanel;
import view.Janela;

import view.RedefinirSenhaPanel;




public class OuvinteDoEnviarCodigoPanel implements ActionListener, KeyListener{
	private JTextField tfEmail;
	
	String codigo = "";
	JTextField tfCodigo = null;
	
	public OuvinteDoEnviarCodigoPanel(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		Email mensageiro = new Email();
		String codigo = "";
		String email = tfEmail.getText();

		
		switch(acao) {
		case"Enviar código":
			if(email.isBlank()) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Digite alguma coisa!");
				break;
			}
			for (int i = 0; i < 6; i++) {
				codigo += (int) (Math.random()*10);
			}
				EnviarCodigoPanel.setCodigo(codigo);
				
				mensageiro.enviarEmailParaCliente(email, "Codigo de recuperação", "O seu codigo de recuperação é: "+codigo);
				JOptionPane.showMessageDialog(Janela.getInstance(), "Codigo enviado!");
	
	
			
			break;
			
		case"Cancelar":
			Janela.setPanel(FactoryMethod.fabricar("login", null));
			
			}
		
			
		}
	
	
	public void keyTyped(KeyEvent e) {
		
		if (!Character.isDigit(e.getKeyChar()))
			e.consume();
		
	}

	public void keyPressed(KeyEvent e) {
		tfCodigo = (JTextField) e.getSource();
				
		codigo = tfCodigo.getText();
		if (codigo.length() == 6) {
			tfCodigo.disable();
			tfCodigo.repaint();
			if (codigo.equals(EnviarCodigoPanel.getCodigo())) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Código confirmado", "Verificar código", JOptionPane.INFORMATION_MESSAGE);

			
				Janela.setPanel(new RedefinirSenhaPanel(tfEmail.getText()));
				}
				
			else {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Código incorreto!", "Verificar código", JOptionPane.ERROR_MESSAGE);
				tfCodigo.enable();
				tfCodigo.setText("");
				tfCodigo.repaint();
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
		keyPressed(e);

		
	}
	

}