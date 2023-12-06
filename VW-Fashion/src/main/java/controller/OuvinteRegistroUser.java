package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import chainOfRespon.BaseRegistro;
import chainOfRespon.VerificadorEmail;
import chainOfRespon.VerificadorNascimento;
import chainOfRespon.VerificadorSenha;
import criptografia.SHA256;
import dao.PersistenciaDacException;
import dao.UserDAO;
import model.Administrador;
import model.Cliente;
import model.Fornecedor;
import model.User;
import model.Vendedor;
import simpleFactory.FactoryMethod;
import view.EnderecoPanel;
import view.Janela;

public class OuvinteRegistroUser implements ActionListener {
	private JTextField nome;
	private JTextField email;
	private JPasswordField senha;
	private JPasswordField senhaConfirmar;
	private JFormattedTextField nascimento;
	private JRadioButton cliente;
	private JRadioButton fornecedor;
	private JRadioButton vendedor;

	public OuvinteRegistroUser(JTextField nome, JTextField email, JPasswordField senha, JPasswordField senhaConfirmar,
			JFormattedTextField nascimento, JRadioButton radioCliente, JRadioButton radioFornecedor,
			JRadioButton radioVendedor) {

		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.senhaConfirmar = senhaConfirmar;
		this.nascimento = nascimento;
		this.cliente = radioCliente;
		this.fornecedor = radioFornecedor;
		this.vendedor = radioVendedor;

	}

	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		UserDAO dao = new UserDAO();
		User user;

		if (cliente == null) {
			System.out.println("Teste");
			user = new Administrador();
			
		} else if (cliente.isSelected()) {
			user = new Cliente();
		}
		
		else if (fornecedor.isSelected()) {
			user = new Fornecedor();
		} else {
			user = new Vendedor();
		}
		if (acao.equals("enviar")) {
			user.setNome(nome.getText());
			user.setEmail(email.getText());

			String senhaCriptografada = SHA256.criptografar(senha.getText());
			user.setSenha(senhaCriptografada);
			String data = nascimento.getText();
			Date nascimento = new Date();
			try {
				nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
				user.setNascimento(nascimento);
			} catch (java.text.ParseException e1) {

				e1.printStackTrace();
			}

			BaseRegistro reg = new VerificadorEmail(new VerificadorSenha(new VerificadorNascimento(null)));

			if (senha.getText().equals(senhaConfirmar.getText())) {
				if (cliente == null) {
					if (reg.processar(user) == true) {
						try {
							dao.save(user);
							Janela.setPanel(FactoryMethod.fabricar("login", null));
						} catch (PersistenciaDacException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				} else if (cliente.isSelected()) {
					if (reg.processar(user) == true)
						Janela.setPanel(new EnderecoPanel((Cliente) user));
				}

				else {
					try {
						if (reg.processar(user) == true) {
							dao.save(user);
							Janela.setPanel(FactoryMethod.fabricar("user", User.getUser()));
						}

					} catch (PersistenciaDacException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			} else {
				JOptionPane.showMessageDialog(Janela.getInstance(), "As senhas devem ser iguais!");
			}

		} else if (acao.equals("cancelar")) {
			Janela.setPanel(FactoryMethod.fabricar("user", User.getUser()));
		}

	}

}
