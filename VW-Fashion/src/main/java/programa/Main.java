package programa;

import observer.MensageiroObservador;

public class Main {
	
	public static void main(String[] args) {
		
		//Janela.setPanel(FactoryMethod.fabricar("login", null));
		
		MensageiroObservador mensageiro = new MensageiroObservador();
		mensageiro.notificarClientes("Promoção", "Promoção na VW-Fashion");
		
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
