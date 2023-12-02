package criptografia;

import java.security.MessageDigest;

public class SHA256 {
	
	public static String criptografar(String senha) {
		StringBuilder senhaAux = new StringBuilder();
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
			for(byte b : messageDigest) {
				senhaAux.append(String.format("%02X", 0xFF & b));
			}
			return senhaAux.toString();
		}catch (Exception e) {
			
			
		}
		return null;
	}
}
	


