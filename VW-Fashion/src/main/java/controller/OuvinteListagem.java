package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import dao.PersistenciaDacException;
import dao.ProdutoDAO;
import dao.UserDAO;
import model.Produto;
import model.User;
import simpleFactory.FactoryMethod;
import view.Janela;



public class OuvinteListagem implements ActionListener {
	private JTable tabela;
	private JComboBox<String> opcoes;

	public OuvinteListagem(JTable tabela, JComboBox<String> opcoes) {
		this.opcoes = opcoes;
		if (tabela == null)
			tabela = new JTable();
		else
			this.tabela = tabela;
	}

	public void actionPerformed(ActionEvent evento) {
		String acao = evento.getActionCommand();
		String[] opcao = {"Cliente", "Fornecedor", "Produto", "Vendedor"};	

		int linhaSelecionada = 0;

		if ("Editar".equals(acao)) {
			
			// Lógica para o botão "Detalhar"

		} else if ("Excluir".equals(acao)) {
			
			
			int i = 0;
			if (linhaSelecionada == -1)
				JOptionPane.showMessageDialog(Janela.getInstance(), "Selecione Algo Para Excluir");
			else {
				if ("Cliente".equals(opcao[opcoes.getSelectedIndex()]) || "Fornecedor".equals(opcao[opcoes.getSelectedIndex()]) || "Vendedor".equals(opcao[opcoes.getSelectedIndex()])) {
					
					UserDAO userDao = new UserDAO();
					try {
						
						linhaSelecionada = tabela.getSelectedRow();
						String email = (String)tabela.getValueAt(linhaSelecionada, 1);
						User user = userDao.getByID(email);
						String nome = user.getNome();
						userDao.delete(user);
						JOptionPane.showMessageDialog(Janela.getInstance(), nome+" foi deletado com sucesso");
						
						Janela.setPanel(FactoryMethod.fabricar("listagem", User.getUser(), opcao[opcoes.getSelectedIndex()]));
					} catch (PersistenciaDacException e) {
						e.printStackTrace();
					}

				}
				else {
					ProdutoDAO ptDAO = new ProdutoDAO();
					try {
						Produto produto = ptDAO.getAll().get(linhaSelecionada);
						ptDAO.delete(produto);
						Janela.setPanel(FactoryMethod.fabricar("listagem", User.getUser(), opcao[opcoes.getSelectedIndex()]));
					} catch (PersistenciaDacException e) {
						e.printStackTrace();
					}

				}

			}
		} else if ("Filtrar".equals(acao)) {
			Janela.setPanel(FactoryMethod.fabricar("listagem", User.getUser(), opcao[opcoes.getSelectedIndex()]));

		} else if ("Voltar".equals(acao)) {
			Janela.setPanel(FactoryMethod.fabricar("user", User.getUser()));
		}

		// Execute ações adicionais, se necessário
	}
}
