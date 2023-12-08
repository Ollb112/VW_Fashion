package observer;

import java.util.ArrayList;

import dao.PersistenciaDacException;
import dao.UserDAO;
import model.Cliente;
import model.*;

public class MensageiroObservador {
	
	
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	
	public void notificarClientes(String assunto, String mensagem) {
		
		for(Cliente c: clientes) {
			c.enviarEmail(assunto, mensagem);
		}
		
	}
	
	public MensageiroObservador() {
		UserDAO dao = new UserDAO();
		try {
			for(User user: dao.getAll()) {
				if (user instanceof Cliente) {
					clientes.add((Cliente)user);
				}
				
			}
		} catch (PersistenciaDacException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
	
	

}
