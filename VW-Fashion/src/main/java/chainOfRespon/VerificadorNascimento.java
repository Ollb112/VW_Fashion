package chainOfRespon;
import java.util.Date;

import model.User;

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
                System.out.println("Data de nascimento inválida (deve ser anterior à data atual).");
                return false;
            }
        } else {
            System.out.println("Data de nascimento não informada.");
            return false;
        }
	}

}
