package model;

import org.apache.commons.mail.EmailException;

import org.apache.commons.mail.SimpleEmail;

public class Email {
	@SuppressWarnings("deprecation")
	public void  enviarEmailParaCliente(String endereco,String assunto, String menssagem) {
	SimpleEmail email = new SimpleEmail(); 

    try {  
    email.setDebug(true);  //modo debug
    email.setHostName("smtp.gmail.com");  
    email.setAuthentication("naoeosedex@gmail.com","wunqwucukceahrpt");  
    email.setSSL(true);  
    email.addTo(endereco); //destinatario_email 
    email.setFrom(endereco); //destinatario
    email.setSubject(assunto);  
    email.setMsg(menssagem);  
    email.send();  

    } catch (EmailException ex) {  

    System.out.println("erro");  
    	}
	}
	public static void main(String[] a) {
		//Email.enviarEmailParaCliente("oliverlobo10@gmail.com", "Testando","teste1");
	}
}
