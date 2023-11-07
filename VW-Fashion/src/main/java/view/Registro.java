package view;





import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Administrador;
import ouvintes.OuvinteMouse;
import personalizados.MeuJButton;




public class Registro extends JPanel{
	
	private JTextField usuarioCampo;
	private JTextField emailCampo;
	private JFormattedTextField nascimentoCampo;
	private JPasswordField senhaCampo;
	private JPasswordField senhaCampoConfirmar;
	private JRadioButton cliente;
	JComboBox<String> sexosComboBox;
	private JRadioButton fornecedor;
	

	
	public Registro(boolean primeiroUsuario) {
		sexosComboBox = new JComboBox<String>();
		

		setLayout(null);
		
		usuarioCampo = new JTextField("");
		emailCampo = new JTextField("");
		
		
		try {
			nascimentoCampo = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
		}
		senhaCampo = new JPasswordField("");
		senhaCampoConfirmar = new JPasswordField("");
		
		if(!primeiroUsuario) {
			cliente = new JRadioButton("Cliente", true);
			fornecedor = new JRadioButton("Fornecedor", false);
			adicionarRadioButtons();
		}
		
		adicionarJButton();
		adicionarTextField();
		
		
	}
	
	public void adicionarRadioButtons() {
		
		cliente.setBounds(230, 230, 100, 30);
		fornecedor.setBounds(330, 230, 100, 30);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(cliente);
		grupo.add(fornecedor);
		
		add(fornecedor);
		add(cliente);
	}

	
	
	public void adicionarTextField() {
		JLabel usuarioLabel = new JLabel("Usuario");
		usuarioLabel.setForeground(Color.black);
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(Color.black);
		JLabel senhaLabel = new JLabel("Senha");
		senhaLabel.setForeground(Color.black);
		JLabel senhaConfirmarLabel = new JLabel("Confirmar senha");
		senhaConfirmarLabel.setForeground(Color.black);
		JLabel DataDeNascimentoLabel = new JLabel("Data de nascimento");
		DataDeNascimentoLabel.setForeground(Color.black);
		JLabel sexo = new JLabel("Sexo");
		
		String[] s = {"Masculino", "Feminino"};
		
		sexosComboBox = new JComboBox<String>(s);
		sexosComboBox.setBounds(360, 200, 90, 30);
		
		usuarioLabel.setBounds(200, 30, 100, 50);
		usuarioCampo.setBounds(250, 40, 200, 30);
		emailLabel.setBounds(210, 80, 200, 30);
		emailCampo.setBounds(250, 80, 200, 30);
		senhaLabel.setBounds(210, 120, 200, 30);
		senhaCampo.setBounds(250, 120, 200, 30);
		senhaConfirmarLabel.setBounds(150, 160, 200, 30);
		senhaCampoConfirmar.setBounds(250, 160, 200, 30);
		DataDeNascimentoLabel.setBounds(130, 200, 200, 30);
		nascimentoCampo.setBounds(250, 200, 70, 30);
		
		sexo.setBounds(325, 200, 100, 30);
		
		
		
		
		add(usuarioLabel);
		add(usuarioCampo);
		add(emailLabel);
		add(emailCampo);
		add(senhaLabel);
		add(senhaCampo);
		add(senhaConfirmarLabel);
		add(senhaCampoConfirmar);
		add(DataDeNascimentoLabel);
		add(nascimentoCampo);
		add(sexo);
		add(sexosComboBox);
	}
	
	public void adicionarJButton() {
		MeuJButton enviar = new MeuJButton("enviar", 210, 265, 80, 35);
		MeuJButton cancelar = new MeuJButton("cancelar", 340, 265, 85, 35);
		
		
	
		cancelar.setBackground(Color.BLACK);
		cancelar.setForeground(Color.WHITE);
		cancelar.addMouseListener(new OuvinteMouse());
		
		
	
		enviar.setBackground(Color.BLACK);
		enviar.setForeground(Color.WHITE);
		enviar.addMouseListener(new OuvinteMouse());
		
//		MeuJButton anterior = new MeuJButton("icones/flecha.png", "A", 30, 0, 50, 50);
//		MeuJButton posterior = new MeuJButton("icones/flecha.png", "P", 90, 0, 50, 50);
		
		
		
		
//		anterior.setOpaque(false);
//		anterior.setContentAreaFilled(false);
//		anterior.setBorderPainted(false);
//		
//		posterior.setOpaque(false);
//		posterior.setContentAreaFilled(false);
//		posterior.setBorderPainted(false);
		
		add(enviar);
		add(cancelar);
//		add(anterior);
//		add(posterior);
	}
	
	
	

}