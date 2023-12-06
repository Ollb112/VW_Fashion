package view;

import java.awt.Color;

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
import model.Produto;
import model.User;
import personalizados.MeuJButton;
import personalizados.MeuJLabel;

public class Painel_listagem extends JPanel {
	private int x_Layout = 0;
	private int y_Layout = 0;
	
	private JTable tabela;
	private JComboBox<String> opcoes;
	
	private MeuJButton filtrar;
	private MeuJButton detalhar;
	private MeuJButton excluir;
	private MeuJButton voltar;
	public Painel_listagem() {
		setLayout(null);
		addJTable("Produto");
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
			detalhar = new MeuJButton(30, 350, 90, 30, "Detalhar");
			excluir = new MeuJButton(340, 350, 90, 30, "Excluir");
			voltar =  new MeuJButton(670, 350, 90, 30, "Voltar");
			
			add(filtrar);
			add(detalhar);
			add(excluir);
			add(voltar);
		}
		
		public void addJTable(String item) {
			UserDAO usuario = new UserDAO();
			ProdutoDAO produto = new ProdutoDAO();
			DefaultTableModel modeloTabela = new DefaultTableModel();
			//Itens produto
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("Id");
			modeloTabela.addColumn("Marca");
			modeloTabela.addColumn("Valor");
			modeloTabela.addColumn("Quantidade");

			//String[] meses = {"Cliente", "Fornecedor", "Produto","Vendedor"};
			if (item.equals("Produto")) {
				
				try {
					for(Produto p: produto.getAll()) {
						 
							Object[] linha = new Object[4];
							linha[0] = p.getNome_produto();
							linha[1] = p.getId_produto();
							linha[2] = p.getMarca();
							linha[3] = p.getPreco();
							linha[4] = p.getQuantidade();
							modeloTabela.addRow(linha);
						
}
				} catch (PersistenciaDacException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			

			
			tabela = new JTable(modeloTabela);
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane painelTabela = new JScrollPane(tabela);
			painelTabela.setBounds(65, 90, 650, 240);
			add(painelTabela);
			
		}
		
		public void addComboBox() {
			DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
			String[] meses = {"Cliente", "Fornecedor", "Produto","Vendedor"};		
			for (String mes : meses) {
			    comboBoxModel.addElement(mes);
			}

			opcoes = new JComboBox<>(comboBoxModel);
			opcoes.setBounds(10, 50, 150, 30);
			opcoes.setBorder(BorderFactory.createLineBorder(Color.black));
			add(opcoes);
		}
		public static void main(String[] args) {
			Janela.setPanel(new Painel_listagem());

		}
}
