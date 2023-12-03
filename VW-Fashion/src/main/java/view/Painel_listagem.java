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
		addJTable();
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
		
		public void addJTable() {

			DefaultTableModel modeloTabela = new DefaultTableModel();
			modeloTabela.addColumn("Nome");
			modeloTabela.addColumn("Tipo");
			modeloTabela.addColumn("Quantidade");/*Comição Fazer um if para o tipo de 
			filtro e apagar o valor*/
			modeloTabela.addColumn("Valor");
			
			/*for(Fornecedor u: central.getTodosOsFornecedores()) {
				Object[] linha = new Object[4];
				linha[0] = u.getNome();
				linha[1] = u.getTipoDeUsuario();
				linha[2] = u.getServicos().size();
				modeloTabela.addRow(linha);
			}*/
			
			tabela = new JTable(modeloTabela);
			tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane painelTabela = new JScrollPane(tabela);
			painelTabela.setBounds(65, 90, 650, 240);
			add(painelTabela);
			
		}
		
		public void addComboBox() {
			DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
			String[] meses = {"Vendedor", "Fornecedor", "Produto"};		
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
