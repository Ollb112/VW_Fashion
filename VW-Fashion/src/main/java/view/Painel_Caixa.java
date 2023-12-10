package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.OuvintePainelCaixa;
import model.Produto;
import personalizados.MeuJButton;
import personalizados.MeuJLabel;

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
	List<Produto> carrinho;
	public Painel_Caixa(float total, List<Produto> carro) {
		carrinho = carro;
		setLayout(null);
		addTextField();
		addJTable(carrinho);
		addJButton();
		addJLabel(total);
		setVisible(true);
	}
	
	public Painel_Caixa() {
		if (carrinho == null)
			carrinho = new ArrayList<Produto>();
		setLayout(null);
		addTextField();
		addJTable(carrinho);
		addJButton();
		//addJLabel();
		setVisible(true);
	}
	
	public void addJTable(List<Produto> carrinho) {

		DefaultTableModel modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("Id");
		modeloTabela.addColumn("Tipo");
		modeloTabela.addColumn("Marca");
		modeloTabela.addColumn("Quantidade");
		modeloTabela.addColumn("Valor");
		
		for (Produto produto : carrinho) {
			Object[] linha = new Object[5];
			linha[0] = produto.getId_produto();
			linha[1] = produto.getNome_produto();
			linha[2] = produto.getMarca();
			linha[3] = produto.getPreco();
			linha[4] = produto.getQuantidade();
			modeloTabela.addRow(linha);
		}

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
		selecionar = new MeuJButton(385 + x_Layout, 60 + y_Layout, 95, 25, "Selecionar");
		finalizar = new MeuJButton(30, 350, 90, 30, "Finalizar");
		excluir = new MeuJButton(340, 350, 90, 30, "Excluir");
		voltar =  new MeuJButton(670, 350, 90, 30, "Voltar");
		
		selecionar.addActionListener(new OuvintePainelCaixa(tabela, tfCodigo, tfQuantidade));
		finalizar.addActionListener(new OuvintePainelCaixa(tabela, tfCodigo, tfQuantidade));
		excluir.addActionListener(new OuvintePainelCaixa(tabela, tfCodigo, tfQuantidade));
		voltar.addActionListener(new OuvintePainelCaixa(tabela, tfCodigo, tfQuantidade));

		add(selecionar);
		add(finalizar);
		add(excluir);
		add(voltar);
	}
	
	public void addJLabel(float t) {
		MeuJLabel idProduto = new MeuJLabel(205 + x_Layout, 40 + y_Layout, 80, 25,"Id Produto:");
		MeuJLabel quantidade = new MeuJLabel(295 + x_Layout, 40 + y_Layout, 80, 25,"Quantidade:");
		MeuJLabel total = new MeuJLabel(450 + x_Layout, 305 + y_Layout, 100, 25,"Total: " + String.valueOf(t));
		
		add(idProduto);
		add(quantidade);
		add(total);

	}
	
	public static void main(String[] args) {
		float teste = (float) 105.0;
		Janela.setPanel(new Painel_Caixa(teste,null));

	}

	
}
