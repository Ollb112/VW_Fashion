package model;

import org.apache.commons.mail.EmailException;

import org.apache.commons.mail.SimpleEmail;

public class Email {
	@SuppressWarnings("deprecation")
    public boolean enviarEmailParaCliente(String endereco, String assunto, String mensagem) {
        SimpleEmail email = new SimpleEmail();

        try {
            //email.setDebug(true);  // Modo debug
            email.setHostName("smtp.gmail.com");
            email.setAuthentication("naoeosedex@gmail.com","wunqwucukceahrpt");
            email.setSSLOnConnect(true);
            email.addTo(endereco); // Destinatário
            email.setFrom("naoresponda@gmail.com"); // endereço de email
            email.setSubject(assunto);
            email.setMsg(mensagem);
            email.send();
            return true; 

        } catch (EmailException ex) {
            return false; 
        }
    }
}

