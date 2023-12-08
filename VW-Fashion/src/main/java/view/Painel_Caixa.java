package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import personalizados.MeuJButton;

public class Painel_Caixa extends JPanel{
	private int x_Layout = 0;
	private int y_Layout = 0;
	
	private JTable tabela;
	private JTextField tfCodigo;
	private JTextField tfQuantidade;

	private MeuJButton selecionar;
	private MeuJButton finalizar;
	private MeuJButton excluir;
	private MeuJButton voltar;
	
	public Painel_Caixa() {
		setLayout(null);
		addTextField();
		addJTable();
		addJButton();
		setVisible(true);
	}
	
	public void addJTable() {

		DefaultTableModel modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("Produto");
		modeloTabela.addColumn("Quantidade");
		modeloTabela.addColumn("Valor");
		modeloTabela.addColumn("Total");
		
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
		painelTabela.setBounds(205, 90, 350, 210);
		add(painelTabela);
		
	}
	
	public void addTextField() {
		tfCodigo = new JTextField();
		tfQuantidade = new JTextField();
		tfCodigo.setBounds(205 + x_Layout, 60 +  y_Layout, 80, 25);
		tfQuantidade.setBounds(295 + x_Layout, 60 + y_Layout, 80, 25);

		add(tfCodigo);
		add(tfQuantidade);
	}
	
	public void addJButton() {
		selecionar = new MeuJButton(385 + x_Layout, 60 + x_Layout, 95, 25, "Selecionar");
		finalizar = new MeuJButton(30, 350, 90, 30, "Finalizar");
		excluir = new MeuJButton(340, 350, 90, 30, "Excluir");
		voltar =  new MeuJButton(670, 350, 90, 30, "Voltar");
		
		add(selecionar);
		add(finalizar);
		add(excluir);
		add(voltar);
	}
	
	public static void main(String[] args) {
		Janela.setPanel(new Painel_Caixa());

	}

	
}
