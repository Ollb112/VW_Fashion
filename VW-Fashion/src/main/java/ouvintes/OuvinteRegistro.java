package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

import dao.PersistenciaDacException;
import dao.UserDAO;
import model.Cliente;
import model.Fornecedor;
import model.User;
import view.EnderecoPanel;
import view.Janela;
import view.LoginPanel;

public class OuvinteRegistro implements ActionListener{
	private String nome;
	private String email;
	private String senha;
	private String senhaConfirmar;
	private JFormattedTextField nascimento;
	private JRadioButton cliente;
	private JComboBox<String> sexosComboBox;

	
	public OuvinteRegistro(String nome, String email, String senha, String senhaConfirmar, JFormattedTextField nascimento, JRadioButton tipoUser, JComboBox<String> sexosComboBox) {
		this.nome = nome;
		this.email =email;
		this.senha = senha;
		this.senhaConfirmar = senhaConfirmar;
		this.nascimento = nascimento;
		this.cliente = tipoUser;
		this.sexosComboBox = sexosComboBox;
	}

	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		
		UserDAO dao = new UserDAO();
		User user;
		
		if(cliente.isSelected()) {
			user = new Cliente();
		}
		else {
			user = new Fornecedor();
		}
		
		if(acao.equals("enviar")) {
			user.setNome(nome);
			user.setEmail(email);
			String data = nascimento.getText();
			Date nascimento = new Date();		
			try {
				nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
				user.setNascimento(nascimento);
			} catch (java.text.ParseException e1) {
				
				e1.printStackTrace();
			}			
			
			if(cliente.isSelected()) {
				Janela.setPanel(new EnderecoPanel((Cliente)user));
			}
			else {
				try {
					dao.save(user);
				} catch (PersistenciaDacException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(acao.equals("cancelar")) {
			Janela.setPanel(new LoginPanel());
		}
		
	}

}
