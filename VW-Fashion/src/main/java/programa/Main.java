package programa;

import javax.swing.JOptionPane;

import dao.PersistenciaDacException;
import dao.UserDAO;
import model.Administrador;
import simpleFactory.FactoryMethod;
import view.Janela;

public class Main {
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		try {
			if(!dao.getAll().isEmpty()) {
				
				Janela.setPanel(FactoryMethod.fabricar("login", null));
				
			}
				
			else {
				Janela.setPanel(FactoryMethod.fabricar("RegistroUser", new Administrador()));
			}
				
		} catch (PersistenciaDacException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//MensageiroObservador mensageiro = new MensageiroObservador();
		//mensageiro.notificarClientes("Promoção", "Promoção na VW-Fashion");
		
		//ProdutoDAO dao = new ProdutoDAO();
		
		//Produto produto = new Produto();
		
		//produto.setMarca("Lacoste");
		//produto.setNome_produto("Camisa");
		//produto.setPreco(30);
		//try {
			//dao.save(produto);
		//} catch (PersistenciaDacException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}

}
