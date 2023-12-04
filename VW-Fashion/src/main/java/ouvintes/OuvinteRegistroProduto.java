package ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.PersistenciaDacException;
import dao.ProdutoDAO;
import model.Produto;
import model.User;
import simpleFactory.FactoryMethod;
import view.Janela;

public class OuvinteRegistroProduto implements ActionListener{

	private JTextField nomeCampo;
	private JTextField marcaCampo;
	private JTextField precoCampo;
	private JTextField quantidadeCampo;
	private User user;
	
	public OuvinteRegistroProduto(JTextField nomeCampo, JTextField marcaCampo, JTextField precoCampo, JTextField quantidadeCampo, User user) {
		this.nomeCampo = nomeCampo;
		this.marcaCampo = marcaCampo;
		this.precoCampo = precoCampo;
		this.quantidadeCampo = quantidadeCampo;
		this.user = user;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String escolha = e.getActionCommand();
		
		switch(escolha.toUpperCase()) {
			case"ENVIAR":
				Produto produto = new Produto();
				

				produto.setNome_produto(nomeCampo.getText());
				produto.setMarca(marcaCampo.getText());
				
				
				int preco = Integer.parseInt(precoCampo.getText());
				int quantidade = Integer.parseInt(quantidadeCampo.getText());
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);
				
				ProdutoDAO dao = new ProdutoDAO();
			try {
				dao.save(produto);
				JOptionPane.showMessageDialog(Janela.getInstance(), "Produto salvo com sucesso");
				Janela.setPanel(FactoryMethod.fabricar("user", user));
			} catch (PersistenciaDacException e1) {
				JOptionPane.showMessageDialog(Janela.getInstance(), "Ocorreu um ero");
				e1.printStackTrace();
			}
			break;
			case "CANCELAR":
				Janela.setPanel(FactoryMethod.fabricar("user", user));
				break;
				
			
		}
		
	}

}
