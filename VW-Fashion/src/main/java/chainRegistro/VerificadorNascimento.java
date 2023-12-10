package chainRegistro;
import java.util.Date;

import javax.swing.JOptionPane;

import model.User;
import view.Janela;

public class VerificadorNascimento extends RegistroChain{

	public VerificadorNascimento(BaseRegistro proximo) {
		super(proximo);
		
	}
	
	public boolean processar(User usuario) {
		Date nascimento = usuario.getNascimento();
		
		if (nascimento != null) {
            Date dataAtual = new Date();
            if (nascimento.before(dataAtual)) {
                return super.processar(usuario);
            } else {
            	JOptionPane.showMessageDialog(Janela.getInstance(), "Data de nascimento inválida (deve ser anterior à data atual).");
                
                return false;
            }
        } else {
        	JOptionPane.showMessageDialog(Janela.getInstance(), "Data de nascimento não informada!!");
            return false;
        }
	}

}
