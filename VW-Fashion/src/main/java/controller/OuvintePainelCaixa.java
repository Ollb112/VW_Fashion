package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;

import dao.PedidoDAO;
import dao.PersistenciaDacException;
import dao.ProdutoDAO;
import model.Pedido;
import model.Produto;
import model.User;
import simpleFactory.FactoryMethod;
import view.Janela;

public class OuvintePainelCaixa implements ActionListener{
	private JTable tabela;
	private JTextField tfCodigo;
	private JTextField tfQuantidade;

	public OuvintePainelCaixa(JTable tabela,JTextField tfCodigo, JTextField tfQuantidade) {
		if (tabela == null)
			tabela = new JTable();
		else
			this.tabela = tabela;

		this.tfCodigo = tfCodigo;
		this.tfQuantidade = tfQuantidade;
	}

	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		ArrayList<Produto> carrinho = new ArrayList<Produto>();
		int linhaSelecionada = tabela.getSelectedRow();
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = null;
		if ("Selecionar".equals(acao)) {
			ProdutoDAO produto = new ProdutoDAO();
			try {
				for(Produto p: produto.getAll()) {
					if (Integer.parseInt(tfCodigo.getText()) == p.getId_produto()) {
						carrinho.add(p);
						
						float f = 0;
						for (Produto c: carrinho) {
							if (Integer.parseInt(tfQuantidade.getText()) < c.getQuantidade()) {
								pedido = new Pedido();
								pedidoDAO.getByID(String.valueOf(pedido.getIdPedido()));
								p.setQuantidade(p.getQuantidade() - Integer.parseInt(tfQuantidade.getText()));
								produto.update(p);
								c.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
								f += c.getPreco();
								pedido.setProdutos(carrinho);
								pedidoDAO.save(pedido);
							}
						}
						Janela.setPanel(FactoryMethod.fabricar("caixa", User.getUser(), f, pedido.getProdutos()));
					}
				}
			} catch (PersistenciaDacException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if ("Excluir".equals(acao)) {
			Produto produto = carrinho.get(linhaSelecionada);
			carrinho.remove(produto);
		}
		
		else 
			Janela.setPanel(FactoryMethod.fabricar("user", User.getUser()));

	}

}
