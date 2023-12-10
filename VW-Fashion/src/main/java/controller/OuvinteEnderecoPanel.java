package controller;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import dao.PersistenciaDacException;
import dao.UserDAO;
import model.Cliente;
import model.Endereco;
import model.User;
import simpleFactory.FactoryMethod;
import view.Janela;

public class OuvinteEnderecoPanel implements ActionListener{
	private Cliente cliente;
	private JTextField ruaCampo;
	private JTextField bairroCampo;
	private JTextField numeroCampo;
	private JFormattedTextField cepCampo;
	
	public OuvinteEnderecoPanel(Cliente cliente, JTextField ruaCampo, JTextField bairroCampo, JTextField numeroCampo, JFormattedTextField cepCampo) {
		this.ruaCampo = ruaCampo;
		this.bairroCampo = bairroCampo;
		this.numeroCampo = numeroCampo;
		this.cepCampo = cepCampo;
		this.cliente = cliente;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		String acao = e.getActionCommand();
		UserDAO dao = new UserDAO();
		if(acao.equals("enviar")) {
			Endereco endereco = new Endereco();
			endereco.setRua(ruaCampo.getText());
			endereco.setBairro(bairroCampo.getText());
			
			int numero = Integer.parseInt(numeroCampo.getText());
			long cep = Integer.parseInt(cepCampo.getText());
			endereco.setNumero(numero);
			endereco.setCep(cep);
			
			cliente.setEndereco(endereco);
			
			try {
				dao.save(cliente);
				
			} catch (PersistenciaDacException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Janela.setPanel(FactoryMethod.fabricar("user", User.getUser()));
			
		}
		else if(acao.equals("cancelar")) {
			Janela.setPanel(FactoryMethod.fabricar("RegistroUser", User.getUser()));

		}
		
	}

}
