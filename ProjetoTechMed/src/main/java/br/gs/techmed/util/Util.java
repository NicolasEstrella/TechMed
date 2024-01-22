package br.gs.techmed.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

	public String formatarData(LocalDateTime dataString) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String data = dataString.format(formato);
		return data;
	}

	public String criptografar(String senha) {
		String senhaCriptografada = null;
		try {
			MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
			byte[] aux = algoritmo.digest(senha.getBytes("UTF-8"));
			StringBuilder senhaHex = new StringBuilder();
			for(byte b : aux) {
				senhaHex.append(String.format("%02X", 0xFF & b));
			}
			senhaCriptografada = senhaHex.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}		
		return senhaCriptografada;
	}
}
