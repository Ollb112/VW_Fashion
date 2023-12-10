package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dao.PersistenciaDacException;
import dao.ProdutoDAO;
import dao.UserDAO;
import model.Cliente;
import model.Fornecedor;
import model.Produto;
import model.User;
import model.Vendedor;
import personalizados.MeuJButton;
import personalizados.MeuJLabel;
import controller.OuvinteListagem;
public class Painel_listagem extends JPanel {
	private int x_Layout = 0;
	private int y_Layout = 0;

	private JTable tabela;
	private JComboBox<String> opcoes;
	private static int selecionado = 0;
	private MeuJButton filtrar;
	private MeuJButton editar;
	private MeuJButton excluir;
	private MeuJButton voltar;

	public Painel_listagem(String tipo) {
		setLayout(null);
		addJTable(tipo);
		addComboBox();
		addJButton();
		addLabel();
		setVisible(true);
	}

	public void addLabel() {
		MeuJLabel relatorio = new MeuJLabel(370, 2, 100, 15, "Listagem");	

		add(relatorio);
	}

	public void addJButton() {
		filtrar = new MeuJButton(170 + x_Layout, 50 + x_Layout, 80, 30, "Filtrar");
		editar = new MeuJButton(30, 350, 90, 30, "Editar");
		excluir = new MeuJButton(340, 350, 90, 30, "Excluir");
		voltar =  new MeuJButton(670, 350, 90, 30, "Voltar");

		filtrar.addActionListener(new OuvinteListagem(tabela, opcoes));
		editar.addActionListener(new OuvinteListagem(tabela, opcoes));
		excluir.addActionListener(new OuvinteListagem(tabela, opcoes));
		voltar.addActionListener(new OuvinteListagem(tabela, opcoes));

		add(filtrar);
		add(editar);
		add(excluir);
		add(voltar);

	}

	public void addJTable(String item) {
		DefaultTableModel modeloTabela = new DefaultTableModel();

		switch (item) {
		case "Produto":
			modeloTabela.addColumn("Id");
			modeloTabela.addColumn("Tipo");
			modeloTabela.addColumn("Marca");
			modeloTabela.addColumn("Quantidade");
			modeloTabela.addColumn("Valor");

			ProdutoDAO produtoDAO = new ProdutoDAO();
			try {
				for (Produto produto : produtoDAO.getAll()) {
					Object[] linha = new Object[5];
					linha[0] = produto.getId_produto();
					linha[1] = produto.getNome_produto();
					linha[2] = produto.getMarca();
					linha[3] = produto.getPreco();
					linha[4] = produto.getQuantidade();
					modeloTabela.addRow(linha);
				}
			} catch (PersistenciaDacException e) {
				e.printStackTrace();
			}
			break;

		case "Cliente":
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("E-mail");
			modeloTabela.addColumn("Nascimento");
			UserDAO userDAO = new UserDAO();
			try {
				for (User user : userDAO.getAll()) {
					if (user instanceof Cliente) {

						Object[] linha = new Object[3];
						linha[0] = user.getNome();
						linha[1] = user.getEmail();
						linha[2] = user.getNascimento();

						modeloTabela.addRow(linha);
					}
				}
			} catch (PersistenciaDacException e) {
				e.printStackTrace();
			}
			break;

		case "Fornecedor":
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("E-mail");
			modeloTabela.addColumn("Nascimento");
			userDAO = new UserDAO();
			try {
				for (User user : userDAO.getAll()) {
					if (user instanceof Fornecedor) {

						Object[] linha = new Object[3];
						linha[0] = user.getNome();
						linha[1] = user.getEmail();
						linha[2] = user.getNascimento();

						modeloTabela.addRow(linha);
					}
				}
			} catch (PersistenciaDacException e) {
				e.printStackTrace();
			}
			break;

		case "Vendedor":
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("E-mail");
			modeloTabela.addColumn("Nascimento");
			userDAO = new UserDAO();
			try {
				for (User user : userDAO.getAll()) {
					if (user instanceof Vendedor) {

						Object[] linha = new Object[3];
						linha[0] = user.getNome();
						linha[1] = user.getEmail();
						linha[2] = user.getNascimento();
						modeloTabela.addRow(linha);
					}
				}
			} catch (PersistenciaDacException e) {
				e.printStackTrace();
			}
			break;
		default:
			modeloTabela.addColumn("Id");
			modeloTabela.addColumn("Tipo");
			modeloTabela.addColumn("Marca");
			modeloTabela.addColumn("Quantidade");
			modeloTabela.addColumn("Valor");
			break;
		}

		this.tabela = new JTable(modeloTabela);
		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(65, 90, 650, 240);
		add(painelTabela);
	}
	
	public static void setSelecionado(int novo) {
		selecionado = novo;
	}

	public void addComboBox() {
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
		String[] opcao = {"Cliente", "Fornecedor", "Produto","Vendedor"};		
		for (String op : opcao) {
			comboBoxModel.addElement(op);
		}

		opcoes = new JComboBox<>(comboBoxModel);
		opcoes.setSelectedIndex(selecionado);
		opcoes.setBounds(10, 50, 150, 30);
		opcoes.setBorder(BorderFactory.createLineBorder(Color.black));
		add(opcoes);
	}
	public static void main(String[] args) {
		Janela.setPanel(new Painel_listagem("tipo"));

	}
}
